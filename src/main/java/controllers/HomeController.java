package controllers;

import entities.Category;
import entities.Product;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.GenericService;
import services.MailService;
import services.NotificationService;
import services.ProductService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final GenericService genericService;
    private final ProductService productService;
    private final MailService mailService;
    private final NotificationService notificationService;

    @Autowired
    public HomeController(GenericService genericService, ProductService productService, MailService mailService, NotificationService notificationService) {
        this.genericService = genericService;
        this.productService = productService;
        this.mailService = mailService;
        this.notificationService = notificationService;
    }

    @GetMapping("/")
    public String welcome(Model m) {
        List<Product> discounts = productService.getAllDiscounts();
        m.addAttribute("discounts", discounts);
        return "index";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "about-us";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/mail")
    public String mail(@RequestParam String from,
                       @RequestParam String subject,
                       @RequestParam String body) {

        try {
            mailService.sendMail(from, subject, body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class, true);
    }

    @ModelAttribute("all_notifications")
    public List<Product> fetchNotifications(HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null) return new ArrayList<>();
        else return notificationService.readNotifications(u);
    }
}
