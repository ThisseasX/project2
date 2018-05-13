package controllers;

import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    public CartController(GenericService genericService, CartService cartService) {
        this.genericService = genericService;
        this.cartService = cartService;
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

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }
}
