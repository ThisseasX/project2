package services;

import entities.Listing;
import entities.Status;
import exceptions.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ListingService {

    private AccountService accountService;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Transactional
    public String changeListingStatus(HttpSession session, int id) {
        Listing listing = em.find(Listing.class, id);
        Status status = null;

        int statusId = listing.getStatusByStatusId().getStatusId();
        switch (statusId) {
            case 1:
                status = em.find(Status.class, 2);
                break;
            case 2:
            case 4:
                status = em.find(Status.class, 1);
        }

        if (statusId == 4) {
            try {
                accountService.buyAsCoop(session, listing);
            } catch (InsufficientBalanceException e) {
                return "Insufficient Balance";
            }
        }

        listing.setStatusByStatusId(status);
        em.merge(listing);

        //noinspection ConstantConditions
        return status.getStatusName();
    }

    public List<Listing> getAll(String query) {
        if (query.equals("All")) query = "";
        return em
                .createNamedQuery("Listing.getAll" + query, Listing.class)
                .getResultList();
    }

    public List<Listing> search(String query) {
        return em
                .createNamedQuery("Listing.search", Listing.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();
    }

    @Transactional
    public void addNewListing(Listing l) {
        l.setStatusByStatusId(em.find(Status.class, 4));
        em.persist(l);
    }
}
