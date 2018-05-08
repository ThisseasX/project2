package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.WishService;

@RequestMapping("/wishlist")
@Controller
public class WishController {

    private final WishService wishService;

    @Autowired
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @RequestMapping("/{id}")
    public String getWishListByUserId(Model m, @PathVariable int id) {
        m.addAttribute("wishlist", wishService.getWishListByUserId(id));
        return "wishlist";
    }
}
