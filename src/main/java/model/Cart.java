package model;

import entities.Listing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {

    private final Set<Listing> items = new HashSet<>();

    public List<Listing> getItems() {
        return new ArrayList<>(items);
    }

    public void add(Listing l) {
        l.setCartQuantity(1);
        if (!items.add(l)) {
            items
                    .stream()
                    .filter(item -> item.equals(l))
                    .forEach(item -> {

                        int result = item.getCartQuantity() + 1;
                        int max = item.getListingQuantity();
                        item.setCartQuantity(
                                result > max
                                        ? max
                                        : result);
                    });
        }
    }

    public void subtract(Listing l) {
        if (items.contains(l)) {
            for (Listing item : items) {
                if (item.equals(l)) {
                    int result = item.getCartQuantity() - 1;
                    int min = 1;
                    if (result < min) {
                        items.remove(item);
                    } else {
                        item.setCartQuantity(result);
                    }
                }
            }
        }
    }

    public void remove(Listing l) {
        items.remove(l);
    }

    public int getTotalPrice() {
        return items
                .stream()
                .mapToInt((a) -> a.getCartQuantity() * a.getPricePerUnit())
                .sum();
    }
}
