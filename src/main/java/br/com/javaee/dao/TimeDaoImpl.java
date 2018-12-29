package br.com.javaee.dao;

import br.com.javaee.domain.Time;
import org.springframework.stereotype.Repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TimeDaoImpl implements TimeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Time time) {
        em.persist(time);
    }

    @Override
    public List<Time> recuperar() {
        return em.createQuery("select p from Time p", Time.class).getResultList();
    }

    @Override
    public Time recuperarPorID(long id) {
        return em.find(Time.class, id);
    }

    @Override
    public void atualizar(Time time) {
        em.merge(time);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Time.class, id));
    }
}
