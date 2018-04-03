package controllers;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.UserService;

import javax.validation.Valid;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
    public String insertUser(
            Model m,
            @Valid @ModelAttribute("user") User user,
            BindingResult result) {

        if (result.hasErrors()) return "insert";
        userService.insert(user);

        return getAll(m);
    }
}
