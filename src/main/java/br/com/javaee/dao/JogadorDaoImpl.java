package br.com.javaee.dao;

import org.springframework.stereotype.Repository;

import br.com.javaee.domain.Jogador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JogadorDaoImpl implements JogadorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Jogador jogador) {
        em.persist(jogador);
    }

    @Override
    public List<Jogador> recuperarPorTime(long timeId) {
        return em.createQuery("select m from Jogador m where m.time.id = :timeId", Jogador.class)
                .setParameter("timeId", timeId)
                .getResultList();
    }

    @Override
    public Jogador recuperarPorTimeIdEJogadorId(long timeId, long jogadorId) {
        return em.createQuery("select m from Jogador m where m.time.id = :timeId and m.id = :jogadorId", Jogador.class)
                .setParameter("timeId", timeId)
                .setParameter("jogadorId", jogadorId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Jogador jogador) {
        em.merge(jogador);
    }

    @Override
    public void excluir(long jogadorId) {
        em.remove(em.getReference(Jogador.class, jogadorId));
    }

}
