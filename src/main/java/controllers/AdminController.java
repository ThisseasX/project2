package controllers;

import entities.Category;
import entities.Listing;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ListingService;
import services.ProductService;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final ListingService listingService;
    private final ProductService productService;

    @Autowired
    public AdminController(ListingService listingService, ProductService productService) {
        this.listingService = listingService;
        this.productService = productService;
    }

    @GetMapping("/admin_panel")
    public String adminPanel(@ModelAttribute User user) {
        return "admin";
    }

    @GetMapping("/categories")
    public String getAllCategories(Model m) {
        m.addAttribute("categories", productService.getAll(Category.class));
        return "categories";
    }

    @GetMapping("/products/{id}")
    public String getAllProductsById(Model m, @PathVariable("id") int id) {
        m.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "products";
    }

    @GetMapping("/listings/{id}")
    public String getAllListingsById(Model m, @PathVariable("id") int id) {
        m.addAttribute("listings", listingService.getAllListingsByProductId(id));
        return "listings";
    }

    @GetMapping("/products")
    public String getAllProducts(Model m) {
        m.addAttribute("products", productService.getAll(Product.class));
        return "products";
    }

    @GetMapping("/listings")
    public String getAllListings(Model m) {
        m.addAttribute("listings", productService.getAll(Listing.class));
        return "listings";
    }
}
