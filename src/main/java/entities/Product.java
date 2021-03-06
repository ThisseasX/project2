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
    private byte[] image;
    private Double basePriceIn;
    private Double basePriceOut;
    private Integer discount;
    private Unit unitByUnitId;
    private Collection<Listing> listingsByProductId;
    private Collection<Wish> wishesByProductId;
    private Category categoryByCategoryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Lob
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
    @Column(name = "discount")
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

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false)
    public Unit getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(Unit unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
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
