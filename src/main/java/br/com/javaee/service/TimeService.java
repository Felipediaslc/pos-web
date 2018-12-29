package br.com.javaee.service;

import java.util.List;

import br.com.javaee.domain.Time;

public interface TimeService {

    void salvar(Time time);
    List<Time> recuperar();
    Time recuperarPorId(long id);
    void atualizar(Time time);
    void excluir(long id);

}
