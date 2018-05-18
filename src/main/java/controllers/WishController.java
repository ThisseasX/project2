package controllers;

import entities.Category;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.GenericService;
import services.NotificationService;
import services.WishService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/wishlist")
@Controller
public class WishController {

    private final GenericService genericService;
    private final NotificationService notificationService;
    private final WishService wishService;

    @Autowired
    public WishController(GenericService genericService, NotificationService notificationService, WishService wishService) {
        this.genericService = genericService;
        this.notificationService = notificationService;
        this.wishService = wishService;
    }

    @GetMapping
    public String getWishListByUserId(Model m, HttpSession session) {
        User u = (User) session.getAttribute("user");

        if (u != null) {
            List<Product> newProducts = notificationService.readNotifications(u);
            List<Product> wishlist = wishService.getWishListByUser(u);
            m.addAttribute("newProducts", newProducts);
            m.addAttribute("wishlist", wishlist);
            notificationService.deleteNotifications(u);
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

    @ModelAttribute("all_notifications")
    public List<Product> fetchNotifications(HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null) return new ArrayList<>();
        else return notificationService.readNotifications(u);
    }
}
