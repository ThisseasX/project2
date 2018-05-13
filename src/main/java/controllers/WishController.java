package controllers;

import entities.Category;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.GenericService;
import services.WishService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/wishlist")
@Controller
public class WishController {

    private final GenericService genericService;

    private final WishService wishService;

    @Autowired
    public WishController(GenericService genericService, WishService wishService) {
        this.genericService = genericService;
        this.wishService = wishService;
    }

    @GetMapping
    public String getWishListByUserId(Model m, HttpSession session) {
        User u = (User) session.getAttribute("user");

        if (u != null) {
            List<Product> wishlist = wishService.getWishListByUser(u);
            m.addAttribute("wishlist", wishlist);
            return "wishlist";
        }

        return "redirect:/users/login";
    }

    @PostMapping("/{productId}")
    public void toggleUserWish(HttpSession session, @PathVariable int productId) {
        User u = (User) session.getAttribute("user");
        wishService.toggle(u, productId);
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }
}
