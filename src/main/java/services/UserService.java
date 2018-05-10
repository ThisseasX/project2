package services;

import entities.User;
import org.mindrot.jbcrypt.BCrypt;
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

    public User contains(User u) {
        try {
            return em
                    .createNamedQuery("User.getByUsername", User.class)
                    .setParameter("username", u.getUsername())
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User login(User u) {
        User existingUser;
        if ((existingUser = contains(u)) != null
                && BCrypt.checkpw(u.getPassword(), existingUser.getPassword())) {
            return existingUser;
        }
        return null;
    }

    @Transactional
    public void register(User u) {
        u.setPassword(BCrypt.hashpw(u.getPassword(), BCrypt.gensalt(12)));
        em.persist(u);
    }
}
