package br.com.javaee.dao;

import java.util.List;

import br.com.javaee.domain.Time;

public interface TimeDao {

    void salvar(Time time);
    List<Time> recuperar();
    Time recuperarPorID(long id);
    void atualizar(Time time);
    void excluir(long id);

}
