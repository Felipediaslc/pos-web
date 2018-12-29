package br.com.javaee.service;

import br.com.javaee.dao.TimeDao;
import br.com.javaee.domain.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeDao timeDao;

    @Override
    public void salvar(Time time) {
    	timeDao.salvar(time);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Time> recuperar() {
        return timeDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public Time recuperarPorId(long id) {
        return timeDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Time time) {
    	timeDao.atualizar(time);
    }

    @Override
    public void excluir(long id) {
    	timeDao.excluir(id);
    }

}

