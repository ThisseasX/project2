package services;

import entities.Listing;
import entities.Product;
import entities.Sale;
import entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SaleService {

    @PersistenceContext
    private EntityManager em;

    public List<Sale> getSalesByUser(User u) {
        return em
                .createNamedQuery("Sale.getAllByUser", Sale.class)
                .setParameter("user", u)
                .getResultList();
    }

    public List<Sale> getSalesByBuyer(User u) {
        return em
                .createNamedQuery("Sale.getAllByBuyer", Sale.class)
                .setParameter("buyer", u)
                .getResultList();
    }

    public List<Sale> getAllSalesBetweenDates(String dateStart, String dateEnd) {
        return em
                .createNamedQuery("Sale.getAllBetweenDates", Sale.class)
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .getResultList();
    }

    public List<Sale> getSalesByUserBetweenDates(User u, String dateStart, String dateEnd) {
        return em
                .createNamedQuery("Sale.getAllByUserBetweenDates", Sale.class)
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .setParameter("user", u)
                .getResultList();
    }

    @Transactional
    public void recordSale(Listing l, User u) {
        Sale s = new Sale(l);
        s.setBuyer(u);
        em.persist(s);
    }
}
