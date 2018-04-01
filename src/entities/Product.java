package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    private Integer pId;
    private Integer typeId;
    private String pName;
    private Double priceIn;
    private Double priceOut;
    private Collection<Listing> listingsByPId;
    private Type typeByTypeId;

    @Id
    @Column(name = "p_id", nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "p_name", nullable = false, length = 50)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Basic
    @Column(name = "price_in", nullable = false, precision = 0)
    public Double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Double priceIn) {
        this.priceIn = priceIn;
    }

    @Basic
    @Column(name = "price_out", nullable = false, precision = 0)
    public Double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(Double priceOut) {
        this.priceOut = priceOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (pId != null ? !pId.equals(product.pId) : product.pId != null) return false;
        if (typeId != null ? !typeId.equals(product.typeId) : product.typeId != null) return false;
        if (pName != null ? !pName.equals(product.pName) : product.pName != null) return false;
        if (priceIn != null ? !priceIn.equals(product.priceIn) : product.priceIn != null) return false;
        if (priceOut != null ? !priceOut.equals(product.priceOut) : product.priceOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pId != null ? pId.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (priceIn != null ? priceIn.hashCode() : 0);
        result = 31 * result + (priceOut != null ? priceOut.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByPId")
    public Collection<Listing> getListingsByPId() {
        return listingsByPId;
    }

    public void setListingsByPId(Collection<Listing> listingsByPId) {
        this.listingsByPId = listingsByPId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }
}
