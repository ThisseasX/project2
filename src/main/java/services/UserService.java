package services;

import entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        return em
                .createNamedQuery("User.getAll", User.class)
                .getResultList();
    }

    @SuppressWarnings("unused")
    public User getByUsername(String username) {
        return em
                .createNamedQuery("User.getByUsername", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public boolean contains(User u) {
        try {
            em
                    .createNamedQuery("User.getByUsername", User.class)
                    .setParameter("username", u.getUsername())
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public void insert(User u) {
        em.persist(u);
    }
}
