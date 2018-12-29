package br.com.javaee.controller;

import br.com.javaee.domain.Jogador;
import br.com.javaee.service.JogadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("times/{timeId}/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("timeId") long timeId, ModelMap model) {
        model.addAttribute("jogadores", jogadorService.recuperarPorTime(timeId));
        model.addAttribute("timeId", timeId);
        return new ModelAndView("/jogador/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("jogador") Jogador jogador, @PathVariable("timeId") long timeId) {
        return "/jogador/add";
    }

    @PostMapping("/salvar")
    public String salvar(@PathVariable("timeId") long timeId, @Valid @ModelAttribute("jogador") Jogador jogador, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/jogador/add";
        }

        jogadorService.salvar(jogador, timeId);
        attr.addFlashAttribute("mensagem", "Jogador salva com sucesso.");
        return "redirect:/times/" + timeId + "/jogadores/listar";
    }

    @GetMapping("/{jogadorId}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("timeId") long timeId, @PathVariable("jogadorId") long jogadorId, ModelMap model) {
        Jogador jogador = jogadorService.recuperarPorTimeIdEJogadorId(timeId, jogadorId);
        model.addAttribute("jogador", jogador);
        model.addAttribute("timeId", timeId);
        return new ModelAndView("/jogador/add", model);
    }

    @PutMapping("/salvar")
    public String atualizar(@PathVariable("timeId") long timeId, @Valid @ModelAttribute("jogador") Jogador jogador, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/jogador/add";
        }

        jogadorService.atualizar(jogador, timeId);
        attr.addFlashAttribute("mensagem", "Jogador atualizada com sucesso.");
        return "redirect:/times/" + timeId + "/jogadores/listar";
    }

    @GetMapping("/{jogadorId}/remover")
    public String remover(@PathVariable("timeId") long timeId, @PathVariable("jogadorId") long jogadorId, RedirectAttributes attr) {
        jogadorService.excluir(timeId, jogadorId);
        attr.addFlashAttribute("mensagem", "Jogador excluída com sucesso.");
        return "redirect:/times/" + timeId + "/jogadores/listar";
    }

}
