package controllers;

import entities.Category;
import exceptions.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.AccountService;
import services.CartService;
import services.GenericService;

import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/cart")
@Controller
public class CartController {

    private final GenericService genericService;
    private final CartService cartService;
    private final AccountService accountService;

    @Autowired
    public CartController(GenericService genericService, CartService cartService, AccountService accountService) {
        this.genericService = genericService;
        this.cartService = cartService;
        this.accountService = accountService;
    }

    @GetMapping
    public String viewCart() {
        return "cart";
    }

    @PostMapping("/{action}/{id}")
    public ResponseEntity addToCart(HttpSession session,
                                    @PathVariable String action,
                                    @PathVariable int id) {
        cartService.modify(session, action, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model m, RedirectAttributes redirectAttributes) {

        if (session.getAttribute("user") == null) return "redirect:/users/login";
        if (session.getAttribute("cart") == null) return "redirect:/listings";

        m.addAttribute("checked_out_cart", session.getAttribute("cart"));
        try {
            accountService.checkoutAsClient(session);
        } catch (InsufficientBalanceException e) {
            redirectAttributes.addFlashAttribute("error", "Insufficient Balance");
            return "redirect:/cart";
        }
        return "checkout";
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }
}
