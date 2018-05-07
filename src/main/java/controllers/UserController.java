package controllers;

import entities.Role;
import entities.User;
import org.mindrot.jbcrypt.BCrypt;
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
@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAll(Model m) {
        m.addAttribute("list", userService.getAll());
        return "users";
    }

    @GetMapping("/register")
    public String insertForm(@ModelAttribute User user) {
        return "register";
    }

    @PostMapping("/register")
    public String insertUser(
            Model m,
            @Valid @ModelAttribute("user") User user,
            BindingResult result) {

        if (userService.contains(user))
            result.rejectValue("username", "username.exists", "Username already exists!");

        if (result.hasErrors()) return "register";

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        userService.insert(user);

        return getAll(m);
    }

    @GetMapping("/admin_panel")
    public String adminPanel(@ModelAttribute User user) {
        return "admin";
    }

    @ModelAttribute("all_roles")
    public List<Role> getAllRoles() {
        return productService.getAll(Role.class);
    }
}
