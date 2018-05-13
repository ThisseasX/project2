package controllers;

import entities.Category;
import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.GenericService;
import services.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/users")
@Controller
public class UserController {

    private final GenericService genericService;
    private final UserService userService;

    @Autowired
    public UserController(GenericService genericService, UserService userService) {
        this.genericService = genericService;
        this.userService = userService;
    }

    // TODO: Might have to reposition this
    @GetMapping("/all")
    public String getAll(Model m) {
        m.addAttribute("list", userService.getAll());
        return "users";
    }

    @GetMapping("/register")
    public String registerForm(@ModelAttribute User user) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           HttpSession session) {

        if (userService.exists(user) != null)
            result.rejectValue("username", "username.exists", "Username already exists!");

        if (result.hasErrors()) return "register";

        userService.register(user);

        session.setAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @ModelAttribute("user") User user, BindingResult result) {

        User u;

        if ((u = userService.login(user)) != null) {
            session.setAttribute("user", u);
            return "redirect:/";
        } else {
            result.rejectValue("username", "login.fail", "Login Failed");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @ModelAttribute("all_roles")
    public List<Role> getAllRoles() {
        return genericService.getAll(Role.class);
    }

    @ModelAttribute("categories")
    public List<Category> fetchCategories() {
        return genericService.getAll(Category.class);
    }
}
