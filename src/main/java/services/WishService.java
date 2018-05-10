package services;

import entities.Product;
import entities.User;
import entities.Wish;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class WishService {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getWishListByUser(User u) {
        return em
                .createNamedQuery("Product.getWishlistByUser", Product.class)
                .setParameter("user", u)
                .getResultList();
    }

    @Transactional
    public void toggle(User u, int productId) {
        Wish incoming;
        try {
            incoming = validate(u, productId);
        } catch (Exception e) {
            return;
        }

        Wish existing;
        try {
            existing = exists(incoming);
            em.remove(existing);
        } catch (Exception e) {
            em.persist(incoming);
        }
    }

    private Wish validate(User u, int productId) throws Exception {
        Product p = em.find(Product.class, productId);

        if (u == null) throw new Exception("No such user");
        if (p == null) throw new Exception("No such product");

        return new Wish(u, p);
    }

    private Wish exists(Wish w) throws Exception {
        return em
                .createNamedQuery("Wish.exists", Wish.class)
                .setParameter("user", w.getUserByUserId())
                .setParameter("product", w.getProductByProductId())
                .getResultList()
                .get(0);
    }
}
