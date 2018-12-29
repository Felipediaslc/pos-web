package br.com.javaee.controller;

import br.com.javaee.domain.Time;
import br.com.javaee.service.TimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("times", timeService.recuperar());
        return new ModelAndView("/time/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("time") Time time) {
        return "/time/add";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("time") Time time, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/time/add";
        }

        timeService.salvar(time);
        attr.addFlashAttribute("mensagem", "Time criada com sucesso.");
        return "redirect:/times/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Time time = timeService.recuperarPorId(id);
        model.addAttribute("time", time);
        return new ModelAndView("/time/add", model);
    }

    @PutMapping("/salvar")
    public String atualizar(@Valid @ModelAttribute("time") Time time, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/times/add";
        }

        timeService.atualizar(time);
        attr.addFlashAttribute("mensagem", "Time atualizada com sucesso.");
        return "redirect:/times/listar";
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        timeService.excluir(id);
        attr.addFlashAttribute("mensagem", "Time excluída com sucesso.");
        return "redirect:/times/listar";
    }

}
