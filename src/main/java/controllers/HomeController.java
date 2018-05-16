package controllers;

import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import services.GenericService;

import java.util.List;

@Controller
public class HomeController {

    private final GenericService genericService;

    @Autowired
    public HomeController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping("/")
    public String welcome() {
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
    public String faq() {
        return "faq";
    }
}
