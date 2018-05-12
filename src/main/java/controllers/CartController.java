package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.CartService;

import javax.servlet.http.HttpSession;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/cart")
@Controller
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart() {
        return "cart";
    }

    @PostMapping("/{id}/{action}")
    public ResponseEntity addToCart(HttpSession session,
                          @PathVariable int id,
                          @PathVariable String action) {
        cartService.modify(session, id, action);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/clear")
    public ResponseEntity clearCart(HttpSession session) {
        session.setAttribute("cart", null);
        return new ResponseEntity(HttpStatus.OK);
    }
}
