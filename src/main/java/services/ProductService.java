package services;

import entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    public <T> List<T> getAll(Class<T> c) {
        return em
                .createNamedQuery(c.getSimpleName() + ".getAll", c)
                .getResultList();
    }

    @Transactional
    public <T> void insert(T t) {
        em.persist(t);
    }

    public boolean contains(Product p) {
        try {
            em
                    .createNamedQuery("Product.getByProductName", Product.class)
                    .setParameter("name", p.getProductName())
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
