package entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({
        @NamedQuery(name = "Product.getAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.getAllDiscounts", query = "SELECT p FROM Product p WHERE p.discount >= 1"),
        @NamedQuery(name = "Product.getByProductName", query = "SELECT p FROM Product p WHERE p.productName = :name"),
        @NamedQuery(name = "Product.getByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryByCategoryId.categoryId = :id"),
        @NamedQuery(name = "Product.getWishlistByUser", query = "SELECT p FROM Product p JOIN Wish w ON w.productByProductId = p AND w.userByUserId = :user")
})
@Entity
public class Product {

    private Integer productId;
    private String productName;
    private String imagePath;
    private Double basePriceIn;
    private Double basePriceOut;
    private Integer discount;
    private Collection<Listing> listingsByProductId;
    private Collection<Wish> wishesByProductId;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name", nullable = false, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "image_path", nullable = false, length = -1)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "base_price_in", nullable = false)
    public Double getBasePriceIn() {
        return basePriceIn;
    }

    public void setBasePriceIn(Double basePriceIn) {
        this.basePriceIn = basePriceIn;
    }

    @Basic
    @Column(name = "base_price_out", nullable = false)
    public Double getBasePriceOut() {
        return basePriceOut;
    }

    public void setBasePriceOut(Double basePriceOut) {
        this.basePriceOut = basePriceOut;
    }

    @Basic
    @Column(name = "discount", nullable = false)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId != null ? productId.equals(product.productId) : product.productId == null;
    }

    @Override
    public int hashCode() {
        return productId != null ? productId.hashCode() : 0;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<Listing> getListingsByProductId() {
        return listingsByProductId;
    }

    public void setListingsByProductId(Collection<Listing> listingsByProductId) {
        this.listingsByProductId = listingsByProductId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<Wish> getWishesByProductId() {
        return wishesByProductId;
    }

    public void setWishesByProductId(Collection<Wish> wishesByProductId) {
        this.wishesByProductId = wishesByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
