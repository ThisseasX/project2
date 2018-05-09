package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.ListingService;

@SuppressWarnings("SameReturnValue")
@RequestMapping("/admin")
@Controller
public class AdminController {

    private final ListingService listingService;

    @Autowired
    public AdminController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/change_listing_status/{id}")
    public @ResponseBody
    String changeListingStatus(@PathVariable("id") int id) {
        return listingService.changeListingStatus(id);
    }
}
