package services;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenericService {

    @PersistenceContext
    private EntityManager em;

    public <T> List<T> getAll(Class<T> c) {
        return em
                .createNamedQuery(c.getSimpleName() + ".getAll", c)
                .getResultList();
    }

    public <S, T> List<S> getByTargetId(Class<S> source, Class<T> target, int id) {
        return em
                .createNamedQuery(source.getSimpleName() + ".getBy" + target.getSimpleName() + "Id", source)
                .setParameter("id", id)
                .getResultList();
    }
}
