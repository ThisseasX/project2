package controllers;

import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import services.GenericService;
import services.ListingService;
import services.WishService;

import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@Controller
public class ProductController {

    private final GenericService genericService;
    private final ListingService listingService;
    private final WishService wishService;

    @Autowired
    public ProductController(GenericService genericService,
                             ListingService listingService, WishService wishService) {
        this.genericService = genericService;
        this.listingService = listingService;
        this.wishService = wishService;
    }

    @GetMapping("/categories")
    public String getCategories() {
        return "categories";
    }

    @GetMapping(value = {"/products", "/products/{id}"})
    public String getProducts(Model m,
                              HttpSession session,
                              @PathVariable(required = false) Integer id) {

        User u = (User) session.getAttribute("user");
        m.addAttribute("wishlist", wishService.getWishListByUser(u));

        List<Product> products = id == null ?
                genericService.getAll(Product.class, true) :
                genericService.getByTargetId(Product.class, Category.class, id, true);

        m.addAttribute("products", products);
        return "products";
    }

    @GetMapping(value = {"/listings", "/listings/{id}"})
    public String getListings(Model m,
                              HttpSession session,
                              @PathVariable(required = false) Integer id) {

        User u = (User) session.getAttribute("user");
        boolean isAdmin = false;
        if (u != null) isAdmin = u.isAdmin();

        List<Listing> listings = id == null ?
                genericService.getAll(Listing.class, isAdmin) :
                genericService.getByTargetId(Listing.class, Product.class, id, isAdmin);

        m.addAttribute("listings", listings);
        return "products2";
    }

    @GetMapping("/listings/new")
    public String newListingForm(@ModelAttribute("listing") Listing listing,
                                 Model m) {
        List<Product> products = genericService.getAll(Product.class, true);
        List<Unit> units = genericService.getAll(Unit.class, true);
        m.addAttribute("all_units", units);
        m.addAttribute("all_products", products);
        return "new-listing";
    }

    @PostMapping("/listings/new")
    public String newListing(@ModelAttribute("listing") Listing listing,
                             HttpSession session) {
        User u = (User) session.getAttribute("user");
        listing.setUserByUserId(u);
        listingService.addNewListing(listing);
        return "redirect:/";
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }
}
