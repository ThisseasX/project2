package controllers;

import entities.User;
import entities.Wish;
import exceptions.JpaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.WishService;
import util.Wishlist;

import javax.servlet.http.HttpSession;

@RequestMapping("/wishlist")
@Controller
public class WishController {

    private final WishService wishService;

    @Autowired
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping
    public String getWishListByUserId(Model m, HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u != null) {
            Wishlist wishlist = wishService.getWishListByUserId(u.getUserId());
            if (!wishlist.isEmpty()) {
                m.addAttribute("wishlist", wishlist);
                return "wishlist";
            } else return "redirect:/";
        }
        return "redirect:/users/login";
    }

    @PostMapping("/{productId}")
    public String addWishToUser(RedirectAttributes redirectAttributes,
                                HttpSession session,
                                @PathVariable int productId) {

        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";

        try {
            Wish w = wishService.insertWish(u.getUserId(), productId);
            redirectAttributes.addFlashAttribute("wish", w);
        } catch (JpaException e) {
            redirectAttributes.addFlashAttribute(
                    "error", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "error", "Product already exists");
        }

        return "redirect:/wishlist";
    }
}
