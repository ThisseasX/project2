package services;

import entities.Listing;
import model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void modify(HttpSession session, String action, int id) {
        Cart c = (Cart) session.getAttribute("cart");
        if (c == null) c = new Cart();

        if (id == -1 || action.equals("clear")) {
            session.setAttribute("cart", null);
            return;
        }

        Listing l = em.find(Listing.class, id);

        switch (action) {
            case "add":
                c.add(l);
                break;
            case "subtract":
                c.subtract(l);
                break;
            case "remove":
                c.remove(l);
        }

        session.setAttribute("cart", c);
    }
}
