package services;

import entities.Listing;
import entities.Product;
import entities.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ListingService {

    @PersistenceContext
    private EntityManager em;

    public <T> List<T> getAll(Class<T> c) {
        return em
                .createNamedQuery(c.getSimpleName() + ".getAll", c)
                .getResultList();
    }

    public List<Listing> getAllListingsByProductId(int id) {
        return em
                .createNamedQuery("Listing.getByProductId", Listing.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Transactional
    public <T> void insert(T t) {
        em.persist(t);
    }

    @Transactional
    public String changeListingStatus(int id) {
        Listing listing = em.find(Listing.class, id);
        Status status = null;
        String statusName = null;

        switch (listing.getStatusByStatusId().getStatusId()) {
            case 1:
                status = em.find(Status.class, 2);
                statusName = status.getStatusName();
                break;
            case 2:
            case 4:
                status = em.find(Status.class, 1);
                statusName = status.getStatusName();
        }

        listing.setStatusByStatusId(status);
        em.merge(listing);
        return statusName;
    }

    public boolean contains(Product p) {
        try {
            em
                    .createNamedQuery("Product.getByProductName", Product.class)
                    .setParameter("name", p.getProductName())
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
