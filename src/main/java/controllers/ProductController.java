package controllers;

import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ListingService;
import services.ProductService;
import services.WishService;

import javax.servlet.http.HttpSession;

@SuppressWarnings("SameReturnValue")
@Controller
public class ProductController {

    private final ListingService listingService;
    private final ProductService productService;
    private final WishService wishService;

    @Autowired
    public ProductController(ListingService listingService,
                             ProductService productService,
                             WishService wishService) {
        this.listingService = listingService;
        this.productService = productService;
        this.wishService = wishService;
    }

    @GetMapping("/categories")
    public String getAllCategories(Model m) {
        m.addAttribute("categories", productService.getAll(Category.class));
        return "categories";
    }

    @GetMapping("/products")
    public String getAllProducts(Model m,
                                 HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u != null) m.addAttribute("wishlist", wishService.getWishListByUserId(u.getUserId()));
        m.addAttribute("products", productService.getAll(Product.class));
        return "products";
    }

    @GetMapping("/products/{id}")
    public String getAllProductsById(Model m,
                                     HttpSession session,
                                     @PathVariable("id") int id) {
        User u = (User) session.getAttribute("user");
        if (u != null) m.addAttribute("wishlist", wishService.getWishListByUserId(u.getUserId()));
        m.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "products";
    }

    @GetMapping("/listings")
    public String getAllListings(Model m) {
        m.addAttribute("listings", productService.getAll(Listing.class));
        return "listings";
    }

    @GetMapping("/listings/{id}")
    public String getAllListingsById(Model m, @PathVariable("id") int id) {
        m.addAttribute("listings", listingService.getAllListingsByProductId(id));
        return "listings";
    }
}
