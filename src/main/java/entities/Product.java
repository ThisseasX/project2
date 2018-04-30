package entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQueries({
        @NamedQuery(name = "Product.getAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.getByProductName", query = "SELECT p FROM Product p where p.productName = :name"),
        @NamedQuery(name = "Product.getByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryByCategoryId.categoryId = :id")
})
@Entity
public class Product {

    private Integer productId;
    private String productName;
    private String imagePath;
    private Double basePriceIn;
    private Double basePriceOut;
    private Collection<Listing> listingsByProductId;
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
    @Column(name = "base_price_in", nullable = false, precision = 0)
    public Double getBasePriceIn() {
        return basePriceIn;
    }

    public void setBasePriceIn(Double basePriceIn) {
        this.basePriceIn = basePriceIn;
    }

    @Basic
    @Column(name = "base_price_out", nullable = false, precision = 0)
    public Double getBasePriceOut() {
        return basePriceOut;
    }

    public void setBasePriceOut(Double basePriceOut) {
        this.basePriceOut = basePriceOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return (productId != null ? productId.equals(product.productId) : product.productId == null) &&
                (productName != null ? productName.equals(product.productName) : product.productName == null) &&
                (imagePath != null ? imagePath.equals(product.imagePath) : product.imagePath == null) &&
                (basePriceIn != null ? basePriceIn.equals(product.basePriceIn) : product.basePriceIn == null) &&
                (basePriceOut != null ? basePriceOut.equals(product.basePriceOut) : product.basePriceOut == null);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (basePriceIn != null ? basePriceIn.hashCode() : 0);
        result = 31 * result + (basePriceOut != null ? basePriceOut.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<Listing> getListingsByProductId() {
        return listingsByProductId;
    }

    public void setListingsByProductId(Collection<Listing> listingsByProductId) {
        this.listingsByProductId = listingsByProductId;
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
