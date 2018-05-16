package controllers;

import entities.Category;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import services.AccountService;
import services.GenericService;
import services.ListingService;

import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final GenericService genericService;
    private final ListingService listingService;

    @Autowired
    public AdminController(GenericService genericService, ListingService listingService) {
        this.genericService = genericService;
        this.listingService = listingService;
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
        if (u == null || !u.isAdmin()) return "redirect:/users/login";

        m.addAttribute("listings", listingService.getAll(StringUtils.capitalize(query)));
        return "admin-pending";
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }
}
