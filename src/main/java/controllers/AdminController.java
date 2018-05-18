package controllers;

import entities.Category;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import services.GenericService;
import services.ListingService;
import services.NotificationService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final GenericService genericService;
    private final ListingService listingService;
    private final NotificationService notificationService;

    @Autowired
    public AdminController(GenericService genericService, ListingService listingService, NotificationService notificationService) {
        this.genericService = genericService;
        this.listingService = listingService;
        this.notificationService = notificationService;
    }

    @PostMapping("/change_listing_status/{id}")
    public @ResponseBody
    String changeListingStatus(HttpSession session, @PathVariable int id) {
        return listingService.changeListingStatus(session, id);
    }

    @GetMapping("/listings/{query}")
    public String manageListings(Model m,
                                 HttpSession session,
                                 @PathVariable String query) {

        User u = (User) session.getAttribute("user");
        if (u == null || u.isClient()) return "redirect:/users/login";

        if (u.isVendor()) {
            m.addAttribute("listings", listingService.getAllByUser(u));
        } else if (u.isAdmin()) {
            m.addAttribute("listings", listingService.getAllByStatus(StringUtils.capitalize(query)));
        }

        return "manage-listings";
    }

    @GetMapping("/admin-panel")
    public String adminPanel(HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";
        return "admin-panel";
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
