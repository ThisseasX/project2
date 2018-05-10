package services;

import entities.Listing;
import entities.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ListingService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public String changeListingStatus(int id) {
        Listing listing = em.find(Listing.class, id);
        Status status = null;

        switch (listing.getStatusByStatusId().getStatusId()) {
            case 1:
                status = em.find(Status.class, 2);
                break;
            case 2:
            case 4:
                status = em.find(Status.class, 1);
        }

        listing.setStatusByStatusId(status);
        em.merge(listing);

        //noinspection ConstantConditions
        return status.getStatusName();
    }
}
