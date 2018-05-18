package services;

import entities.Listing;
import entities.Status;
import entities.User;
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

    private final AccountService accountService;
    private final NotificationService notificationService;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ListingService(AccountService accountService, NotificationService notificationService) {
        this.accountService = accountService;
        this.notificationService = notificationService;
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
        if (status.getStatusId() == 1) {
            notificationService.sendNotifications(listing.getProductByProductId());
        }

        //noinspection ConstantConditions
        return status.getStatusName();
    }

    public List<Listing> getAllByStatus(String status) {
        if (status.equals("All")) status = "";
        return em
                .createNamedQuery("Listing.getAll" + status, Listing.class)
                .getResultList();
    }

    public List<Listing> getAllByUser(User u) {
        return em
                .createNamedQuery("Listing.getAllAvailableByUser", Listing.class)
                .setParameter("user", u)
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
