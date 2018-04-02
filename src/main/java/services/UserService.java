package services;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class UserService {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        return em
                .createNamedQuery("User.getAll", User.class)
                .getResultList();
    }

    @Transactional
    public void insert(User u) {
       em.persist(u);
    }
}
