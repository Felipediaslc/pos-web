package br.com.javaee.dao;

import java.util.List;

import br.com.javaee.domain.Jogador;

public interface JogadorDao {

    void salvar(Jogador jogador);
    List<Jogador> recuperarPorTime(long timeId);
    Jogador recuperarPorTimeIdEJogadorId(long timeId, long jogadorId);
    void atualizar(Jogador jogador);
    void excluir(long jogadorId);

}
