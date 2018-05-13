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
import services.GenericService;
import services.WishService;

import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@Controller
public class ProductController {

    private final GenericService genericService;
    private final WishService wishService;

    @Autowired
    public ProductController(GenericService genericService,
                             WishService wishService) {
        this.genericService = genericService;
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
                genericService.getAll(Product.class) :
                genericService.getByTargetId(Product.class, Category.class, id);

        m.addAttribute("products", products);
        return "products";
    }

    @GetMapping(value = {"/listings", "/listings/{id}"})
    public String getListings(Model m, @PathVariable(required = false) Integer id) {

        List<Listing> listings = id == null ?
                genericService.getAll(Listing.class) :
                genericService.getByTargetId(Listing.class, Product.class, id);

        m.addAttribute("listings", listings);
        return "listings";
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class);
    }
}
