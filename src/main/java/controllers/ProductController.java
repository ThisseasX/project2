package controllers;

import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import services.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SameReturnValue")
@Controller
public class ProductController {

    private final GenericService genericService;
    private final ListingService listingService;
    private final ProductService productService;
    private final WishService wishService;
    private final NotificationService notificationService;

    @Autowired
    public ProductController(GenericService genericService,
                             ListingService listingService, ProductService productService, WishService wishService, NotificationService notificationService) {
        this.genericService = genericService;
        this.listingService = listingService;
        this.productService = productService;
        this.wishService = wishService;
        this.notificationService = notificationService;
    }

    @GetMapping("/search")
    public String searchListing(Model m,
                                HttpSession session,
                                @RequestParam String query) {

        User u = (User) session.getAttribute("user");
        m.addAttribute("wishlist", wishService.getWishListByUser(u));

        String selected = "Search Results for: " + query;
        List<Listing> listings = listingService.search(query);

        m.addAttribute("selected", selected);
        m.addAttribute("listings", listings);
        return "products";
    }

    @GetMapping("/categories")
    public String getCategories() {
        return "categories";
    }

    @GetMapping(value = {"/products", "/products/{id}"})
    public String getProducts(Model m,
                              HttpSession session,
                              @PathVariable(required = false) Integer id) {

        User u = (User) session.getAttribute("user");
        m.addAttribute("wishlist", wishService.getWishListByUser(u));

        List<Product> products;
        String selected;
        if (id == null) {
            selected = "All Products";
            products = genericService.getAll(Product.class, true);
        } else {
            selected = genericService.getById(Category.class, id).getCategoryName();
            products = genericService.getByTargetId(Product.class, Category.class, id, true);
        }

        m.addAttribute("selected", selected);
        m.addAttribute("products", products);
        return "products";
    }

    @GetMapping(value = {"/listings", "/listings/{id}"})
    public String getListings(Model m,
                              HttpSession session,
                              @PathVariable(required = false) Integer id) {

        User u = (User) session.getAttribute("user");
        boolean isAdmin = false;
        if (u != null) isAdmin = u.isAdmin();

        List<Listing> listings;
        String selected;
        if (id == null) {
            selected = "All Products";
            listings = genericService.getAll(Listing.class, isAdmin);
        } else {
            selected = genericService.getById(Product.class, id).getProductName();
            listings = genericService.getByTargetId(Listing.class, Product.class, id, isAdmin);
        }

        m.addAttribute("selected", selected);
        m.addAttribute("listings", listings);
        return "products";
    }

    @GetMapping("/listings/new")
    public String newListingChoice(Model m) {
        List<Product> products = genericService.getAll(Product.class, true);
        m.addAttribute("all_products", products);
        return "new-listing-choice";
    }

    @GetMapping("/listings/new/{id}")
    public String newListingForm(@PathVariable int id,
                                 Model m) {
        Product selected = genericService.getById(Product.class, id);
        Listing listing = new Listing();
        listing.setPricePerUnit(selected.getBasePriceIn());
        listing.setProductByProductId(selected);
        m.addAttribute("listing", listing);
        m.addAttribute("selected", selected);
        return "new-listing";
    }

    @PostMapping("/listings/new/{id}")
    public String newListing(@RequestParam String listingName,
                             @RequestParam int listingQuantity,
                             @PathVariable int id,
                             HttpSession session) {
        Product selected = genericService.getById(Product.class, id);
        User u = (User) session.getAttribute("user");

        Listing listing = new Listing();
        listing.setListingName(listingName);
        listing.setListingQuantity(listingQuantity);
        listing.setPricePerUnit(selected.getBasePriceIn());
        listing.setProductByProductId(selected);
        listing.setUserByUserId(u);

        listingService.addNewListing(listing);
        return "redirect:/listings/" + id;
    }

    @GetMapping("/products/new")
    public String newProductChoice(Model m, HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null || u.isVendor()) return "redirect:/listings/new";

        List<Category> categories = genericService.getAll(Category.class, true);
        m.addAttribute("all_categories", categories);
        return "new-product-choice";
    }

    @GetMapping("/products/new/{id}")
    public String newProductForm(@PathVariable int id,
                                 Model m) {
        Category selected = genericService.getById(Category.class, id);
        List<Unit> units = genericService.getAll(Unit.class, true);

        m.addAttribute("all_units", units);
        m.addAttribute("selected", selected);
        return "new-product";
    }

    @PostMapping("/products/new/{id}")
    public String newProduct(@RequestParam String productType,
                             @RequestParam double pricePerUnit,
                             @RequestParam int unitId,
                             @RequestParam MultipartFile image,
                             @PathVariable int id) {
        Category selected = genericService.getById(Category.class, id);
        Unit unit = genericService.getById(Unit.class, unitId);

        Product product = new Product();
        product.setBasePriceIn(pricePerUnit);
        product.setBasePriceOut(pricePerUnit * 3);
        product.setCategoryByCategoryId(selected);
        product.setUnitByUnitId(unit);
        product.setProductName(productType);
        product.setDiscount(0);

        try {
            product.setImage(getResizedImage(image));
        } catch (IOException e) {
            product.setImage(new byte[]{});
            e.printStackTrace();
        }

        productService.addNewProduct(product);
        return "redirect:/products/" + id;
    }

    @GetMapping("/{action}/image/{id}")
    public void viewImage(HttpServletResponse response,
                          @PathVariable String action,
                          @PathVariable int id) throws IOException {


        byte[] documentInBytes = getImage(action, id);
        response.setDateHeader("Expires", -1);
        response.setContentType("image/png");
        response.setContentLength(documentInBytes.length);
        response.getOutputStream().write(documentInBytes);
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

    private byte[] getResizedImage(@RequestParam MultipartFile image) throws IOException {
        BufferedImage buffered = resizeImage(image);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ImageIO.write(buffered, "png", byteStream);
        byteStream.flush();

        byte[] img = byteStream.toByteArray();
        byteStream.close();

        return img;
    }

    private BufferedImage resizeImage(MultipartFile image) throws IOException {
        BufferedImage originalImage = ImageIO.read(image.getInputStream());

        int height = originalImage.getHeight();
        int width = originalImage.getWidth();

        if (height <= 150 && width <= 150) return originalImage;

        return originalImage.getSubimage(0, 0, 150, 150);
    }

    private byte[] getImage(String action, int id) {
        if (action.equals("products")) {
            return genericService.getById(Product.class, id).getImage();
        } else {
            return genericService.getById(Listing.class, id).getImage();
        }
    }
}
