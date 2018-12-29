package br.com.javaee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.javaee.dao.JogadorDao;
import br.com.javaee.domain.Jogador;

@Service
@Transactional
public class JogadorServicelmpl implements JogadorService {

    @Autowired
    private JogadorDao jogadorDao;

    @Autowired
    private TimeService timeService;

    @Override
    public void salvar(Jogador jogador, long timeId) {
        jogador.setTime(timeService.recuperarPorId(timeId));
        jogadorDao.salvar(jogador);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jogador> recuperarPorTime(long timeId) {
        return jogadorDao.recuperarPorTime(timeId);
    }

    @Override
    @Transactional(readOnly = true)
    public Jogador recuperarPorTimeIdEJogadorId(long timeId, long jogadorId) {
        return jogadorDao.recuperarPorTimeIdEJogadorId(timeId, jogadorId);
    }

    @Override
    public void atualizar(Jogador jogador, long timeId) {
        jogador.setTime(timeService.recuperarPorId(timeId));
        jogadorDao.atualizar(jogador);
    }

    @Override
    public void excluir(long timeId, long jogadorId) {
        jogadorDao.excluir(recuperarPorTimeIdEJogadorId(timeId, jogadorId).getId());
    }

	@Override
	public void salva(Jogador jogador, long timeId) {
		// TODO Auto-generated method stub
		
	}

}
