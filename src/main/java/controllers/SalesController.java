package controllers;

import entities.Sale;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import services.GenericService;
import services.SaleService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/sales")
@Controller
public class SalesController {

    private final GenericService genericService;
    private final SaleService saleService;

    @Autowired
    public SalesController(GenericService genericService, SaleService saleService) {
        this.genericService = genericService;
        this.saleService = saleService;
    }

    @GetMapping("/all")
    public String getAllSales(HttpSession session, Model m) {
        User u = (User) session.getAttribute("user");
        if (u == null || !u.isAdmin()) return "redirect:/users/login";

        m.addAttribute("sales", genericService.getAll(Sale.class, true));
        return "sales";
    }

    @GetMapping("/user")
    public String getSalesByUser(HttpSession session, Model m) {
        User u = (User) session.getAttribute("user");
        if (u == null) return "redirect:/users/login";

        m.addAttribute("sales", saleService.getSalesByUser(u));
        return "sales";
    }

    @GetMapping("/all/dates")
    public String getAllSalesBetweenDates(Model m,
                                          @RequestParam Date dateStart,
                                          @RequestParam Date dateEnd) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh/mm/ss");
        String startDate = sdf.format(dateStart);
        String endDate = sdf.format(dateEnd);

        m.addAttribute("sales", saleService.getAllSalesBetweenDates(
                startDate,
                endDate
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
    public void initBinder(WebDataBinder binder) {
        String datePattern = "yyyy/MM/dd hh/mm/ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
