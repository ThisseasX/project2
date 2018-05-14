package services;

import entities.Account;
import entities.Listing;
import entities.User;
import model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AccountService {

    private UserService userService;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void buyAsCoop(HttpSession session, Listing listing) {
        Account coop = em.find(Account.class, 1);
        Account vendor = getUserAccount(listing.getUserByUserId());

        double amount = listing.getPricePerUnit() * listing.getListingQuantity();

        transferBalance(coop, vendor, amount);

        session.setAttribute("user", userService.getAdmin());
    }

    @Transactional
    public void checkoutAsClient(HttpSession session) {
        User u = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");

        double amount = cart.getTotalPrice();

        Account client = getUserAccount(u);
        Account coop = em.find(Account.class, 1);

        transferBalance(client, coop, amount);

        finalizeCart(cart);
        splitProfits(amount);

        session.setAttribute("cart", null);
        session.setAttribute("user", em.find(User.class, u.getUserId()));
    }

    private void splitProfits(double amount) {
        List<Account> vendorAccounts = getAllVendorAccounts();
        int vendors = vendorAccounts.size();

        double half = amount / 2;
        double share = half / vendors;

        Account coop = em.find(Account.class, 1);
        subtractBalance(coop, half);

        for (Account vendor : vendorAccounts) {
            addBalance(vendor, share);
        }
    }

    private List<Account> getAllVendorAccounts() {
        return em
                .createNamedQuery("Account.getAllVendors", Account.class)
                .getResultList();
    }

    private void finalizeCart(Cart cart) {
        for (Listing l : cart.getItems()) {
            subtractQuantity(l);
            em.merge(l);
        }
    }

    private void subtractQuantity(Listing l) {
        l.setListingQuantity(l.getListingQuantity() - l.getCartQuantity());
    }

    public double getBalance(HttpSession session) {
        return getUserAccount((User) session.getAttribute("user")).getBalance();
    }

    @Transactional
    public void transferBalance(Account from, Account to, double amount) {
        subtractBalance(from, amount);
        addBalance(to, amount);
    }

    private void subtractBalance(Account from, double amount) {
        from.setBalance(from.getBalance() - amount);
        em.merge(from);
    }

    private void addBalance(Account to, double amount) {
        to.setBalance(to.getBalance() + amount);
        em.merge(to);
    }

    private Account getUserAccount(User u) {
        return em
                .createNamedQuery("Account.getByUser", Account.class)
                .setParameter("user", u)
                .getResultList()
                .get(0);
    }
}
