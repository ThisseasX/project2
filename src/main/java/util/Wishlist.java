package util;

import entities.Product;
import entities.Wish;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {

    private final List<Wish> wishes;

    public Wishlist(List<Wish> wishes) {
        this.wishes = wishes;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public boolean contains(Product p) {
        List<Product> productList = new ArrayList<>();
        for (Wish wish : wishes) {
            productList.add(wish.getProductByProductId());
        }
        return productList.contains(p);
    }

    public boolean isEmpty() {
        return wishes.size() <= 0;
    }
}
