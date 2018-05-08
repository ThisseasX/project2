package services;

import entities.Wish;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class WishService {

    @PersistenceContext
    private EntityManager em;

    public List<Wish> getWishListByUserId(int userId) {
        return em
                .createNamedQuery("Wish.getByUserId", Wish.class)
                .setParameter("id", userId)
                .getResultList();
    }

    @Transactional
    public void insertWish(Wish w) {
        em.persist(w);
    }
}
