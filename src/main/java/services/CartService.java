package services;

import entities.Listing;
import model.Cart;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Repository
public class CartService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void modify(HttpSession session, int id, String action) {
        Cart c = (Cart) session.getAttribute("cart");
        if (c == null) c = new Cart();

        Listing l = em.find(Listing.class, id);

        if (action.equals("add")) c.add(l);
        else if (action.equals("subtract")) c.subtract(l);

        session.setAttribute("cart", c);
    }
}
