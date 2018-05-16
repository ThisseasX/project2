package controllers;

import entities.Category;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import services.GenericService;
import services.ProductService;

import java.util.List;

@Controller
public class HomeController {

    private final GenericService genericService;
    private final ProductService productService;

    @Autowired
    public HomeController(GenericService genericService, ProductService productService) {
        this.genericService = genericService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String welcome(Model m) {
        List<Product> discounts = productService.getAllDiscounts();
        m.addAttribute("discounts", discounts);
        return "index";
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "about-us";
    }

    @GetMapping("/faq")
    public String faq() { return "faq"; }

    @GetMapping("/contact")
    public String contact() { return "contact"; }
}
