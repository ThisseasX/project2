package services;

import entities.*;
import exceptions.InsufficientBalanceException;
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

    private final UserService userService;
    private final SaleService saleService;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public AccountService(UserService userService, SaleService saleService) {
        this.userService = userService;
        this.saleService = saleService;
    }

    @Transactional
    public void buyAsCoop(HttpSession session, Listing listing) throws InsufficientBalanceException {
        Account coop = em.find(Account.class, 1);
        Account vendor = listing.getUserByUserId().getAccount();

        double amount = listing.getProductByProductId().getBasePriceIn() * listing.getListingQuantity();

        transferBalance(coop, vendor, amount);

        session.setAttribute("user", userService.getAdmin());
    }

    @Transactional
    public void checkoutAsClient(HttpSession session) throws InsufficientBalanceException {
        User u = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");

        double amount = cart.getTotalPrice();

        Account client = u.getAccount();
        Account coop = em.find(Account.class, 1);

        transferBalance(client, coop, amount);

        finalizeCart(cart);
        splitProfits(amount);

        session.setAttribute("cart", null);
        session.setAttribute("user", em.find(User.class, u.getUserId()));
    }

    private void finalizeCart(Cart cart) {
        for (Listing l : cart.getItems()) {
            saleService.recordSale(l);
            subtractQuantity(l);
            em.merge(l);
        }
    }

    private void splitProfits(double amount) {
        List<Account> vendorAccounts = getAllVendorAccounts();
        int vendors = vendorAccounts.size() > 1 ? vendorAccounts.size() : 1;

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

    private void subtractQuantity(Listing l) {
        l.setListingQuantity(l.getListingQuantity() - l.getCartQuantity());
        if (l.getListingQuantity() < 1) {
            l.setStatusByStatusId(em.find(Status.class, 3));
        }
    }

    @Transactional
    public void transferBalance(Account from, Account to, double amount) throws InsufficientBalanceException {
        if (from.getBalance() - amount < 0) throw new InsufficientBalanceException();
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
}
