package controllers;

import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ProductService;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/test")
@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAll(Model m) {
        m.addAttribute("role", productService.getAll(Role.class));
        return "roles";
    }
}
