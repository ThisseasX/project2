package services;

import entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getAllDiscounts() {
        return em
                .createNamedQuery("Product.getAllDiscounts", Product.class)
                .getResultList();
    }
}