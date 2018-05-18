package controllers;

import entities.Category;
import entities.Product;
import entities.Sale;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import services.GenericService;
import services.NotificationService;
import services.SaleService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/sales")
@Controller
public class SalesController {

    private final GenericService genericService;
    private final SaleService saleService;
    private final NotificationService notificationService;

    @Autowired
    public SalesController(GenericService genericService, SaleService saleService, NotificationService notificationService) {
        this.genericService = genericService;
        this.saleService = saleService;
        this.notificationService = notificationService;
    }

    @GetMapping("/all")
    public String getAllSales(HttpSession session, Model m) {
        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";
        if (u.isVendor()) {
            return "redirect:/sales/user";
        } else if (u.isAdmin()) {
            m.addAttribute("sales", genericService.getAll(Sale.class, true));
        } else if (u.isVendor()) {
            return "redirect:/sales/buyer";
        }
        return "sales";
    }

    @GetMapping("/user")
    public String getSalesByUser(HttpSession session, Model m) {
        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";

        m.addAttribute("sales", saleService.getSalesByUser(u));
        return "sales";
    }

    @GetMapping("/buyer")
    public String getSalesByBuyer(HttpSession session, Model m) {
        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";

        m.addAttribute("sales", saleService.getSalesByBuyer(u));
        return "sales";
    }

    @GetMapping("/all/dates")
    public String getAllSalesBetweenDates(Model m,
                                          @RequestParam Date dateStart,
                                          @RequestParam Date dateEnd) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String startDate = sdf.format(dateStart);
        String endDate = sdf.format(dateEnd);

        m.addAttribute("sales", saleService.getAllSalesBetweenDates(
                dateStart,
                dateEnd
        ));
        return "sales";
    }

    @GetMapping("/user/{dateStart}/{dateEnd}")
    public String getSalesByUserBetweenDates(Model m,
                                             HttpSession session,
                                             @PathVariable String dateStart,
                                             @PathVariable String dateEnd) {

        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";

        m.addAttribute("sales", saleService.getSalesByUserBetweenDates(
                u,
                dateStart,
                dateEnd
        ));
        return "sales";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
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
