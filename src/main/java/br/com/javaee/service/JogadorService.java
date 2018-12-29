package br.com.javaee.service;

import java.util.List;

import br.com.javaee.domain.Jogador;

public interface JogadorService {

    void salvar(Jogador jogador, long timeId);
    List<Jogador> recuperarPorTime(long timeId);
    Jogador recuperarPorTimeIdEJogadorId(long timeId, long jogadorId);
    void atualizar(Jogador jogador, long timeId);
    void excluir(long timeId, long jogadorId);
	void salva(Jogador jogador, long timeId);

}
