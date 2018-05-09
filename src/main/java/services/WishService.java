package services;

import entities.Product;
import entities.User;
import entities.Wish;
import exceptions.JpaException;
import org.springframework.stereotype.Repository;
import util.Wishlist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class WishService {

    @PersistenceContext
    private EntityManager em;

    public Wishlist getWishListByUserId(int userId) {
        return new Wishlist(em
                .createNamedQuery("Wish.getByUserId", Wish.class)
                .setParameter("id", userId)
                .getResultList());
    }

    @Transactional
    public Wish insertWish(int userId, int productId) throws JpaException {
        User u = em.find(User.class, userId);
        Product p = em.find(Product.class, productId);

        if (u == null) throw new JpaException("No such user");
        if (p == null) throw new JpaException("No such product");

        Wish wish = new Wish();
        wish.setUserByUserId(u);
        wish.setProductByProductId(p);
        em.persist(wish);
        return wish;
    }
}
