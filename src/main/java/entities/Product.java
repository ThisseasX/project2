package entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQuery(name = "Product.getAll", query = "SELECT p FROM Product p")
@Entity
public class Product {

    private Integer productId;
    private Double basePriceIn;
    private Double basePriceOut;
    private Collection<Listing> listingsByProductId;
    private Variety varietyByTypeId;

    @Id
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (basePriceIn != null ? !basePriceIn.equals(product.basePriceIn) : product.basePriceIn != null) return false;
        if (basePriceOut != null ? !basePriceOut.equals(product.basePriceOut) : product.basePriceOut != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
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
    @JoinColumn(name = "type_id", referencedColumnName = "variety_id")
    public Variety getVarietyByTypeId() {
        return varietyByTypeId;
    }

    public void setVarietyByTypeId(Variety varietyByTypeId) {
        this.varietyByTypeId = varietyByTypeId;
    }
}
