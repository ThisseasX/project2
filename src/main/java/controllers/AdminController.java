package controllers;

import entities.Category;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ProductService;
import services.UserService;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAll(Model m) {
        m.addAttribute("list", userService.getAll());
        return "users";
    }

    @GetMapping("/insert_form")
    public String insertForm(@ModelAttribute User user) {
        return "insert";
    }

    @PostMapping("/insert")
    public String insertProduct(
            Model m,
            @Valid @ModelAttribute("product") Product product,
            BindingResult result) {

        if (productService.contains(product))
            result.rejectValue("product", "product.exists", "Product already exists!");

        if (result.hasErrors()) return "insert";

        productService.insert(product);

        return getAll(m);
    }

    @GetMapping("/admin_panel")
    public String adminPanel(@ModelAttribute User user) {
        return "admin";
    }

    @ModelAttribute("all_products")
    public List<Product> getAllProducts() {
        return productService.getAll(Product.class);
    }

    @ModelAttribute("all_categories")
    public List<Category> getAllCategories() {
        return productService.getAll(Category.class);
    }
}
