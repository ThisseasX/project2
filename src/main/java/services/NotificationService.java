package services;

import entities.Notification;
import entities.Product;
import entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class NotificationService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void sendNotifications(Product p) {
        List<User> users = em
                .createNamedQuery("Wish.getAllByProduct", User.class)
                .setParameter("product", p)
                .getResultList();

        users.forEach(a -> em.persist(new Notification(a, p)));
    }

    @Transactional
    public List<Product> readNotifications(User u) {
        return em
                .createNamedQuery("Notification.getAllByUser", Product.class)
                .setParameter("user", u)
                .getResultList();
    }

    @Transactional
    public void deleteNotifications(User u) {
        em
                .createNamedQuery("Notification.deleteAllByUser")
                .setParameter("user", u)
                .executeUpdate();
    }
}

