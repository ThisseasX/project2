package services;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenericService {

    @PersistenceContext
    private EntityManager em;

    public <T> List<T> getAll(Class<T> c, boolean isAdmin) {
        String query = isAdmin ? ".getAll" : ".getAllAvailable";
        return em
                .createNamedQuery(c.getSimpleName() + query, c)
                .getResultList();
    }

    public <S, T> List<S> getByTargetId(Class<S> source, Class<T> target, int id, boolean isAdmin) {
        String query = isAdmin ? ".getBy" : ".getAvailableBy";
        return em
                .createNamedQuery(source.getSimpleName() + query + target.getSimpleName() + "Id", source)
                .setParameter("id", id)
                .getResultList();
    }
}
