package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Listing {
    private Integer lId;
    private Integer pId;
    private Integer uId;
    private Integer quantity;
    private Integer pricePerUnit;
    private Integer status;
    private Timestamp date;
    private Integer unit;
    private Product productByPId;
    private User userByUId;
    private Status statusByStatus;
    private Unit unitByUnit;
    private Collection<Sale> salesByLId;

    @Id
    @Column(name = "l_id", nullable = false)
    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    @Basic
    @Column(name = "p_id", nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price_per_unit", nullable = false)
    public Integer getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "unit", nullable = false)
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        if (lId != null ? !lId.equals(listing.lId) : listing.lId != null) return false;
        if (pId != null ? !pId.equals(listing.pId) : listing.pId != null) return false;
        if (uId != null ? !uId.equals(listing.uId) : listing.uId != null) return false;
        if (quantity != null ? !quantity.equals(listing.quantity) : listing.quantity != null) return false;
        if (pricePerUnit != null ? !pricePerUnit.equals(listing.pricePerUnit) : listing.pricePerUnit != null)
            return false;
        if (status != null ? !status.equals(listing.status) : listing.status != null) return false;
        if (date != null ? !date.equals(listing.date) : listing.date != null) return false;
        if (unit != null ? !unit.equals(listing.unit) : listing.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lId != null ? lId.hashCode() : 0;
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (pricePerUnit != null ? pricePerUnit.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id", nullable = false)
    public Product getProductByPId() {
        return productByPId;
    }

    public void setProductByPId(Product productByPId) {
        this.productByPId = productByPId;
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false)
    public User getUserByUId() {
        return userByUId;
    }

    public void setUserByUId(User userByUId) {
        this.userByUId = userByUId;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "s_id", nullable = false)
    public Status getStatusByStatus() {
        return statusByStatus;
    }

    public void setStatusByStatus(Status statusByStatus) {
        this.statusByStatus = statusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "unit", referencedColumnName = "unit_id", nullable = false)
    public Unit getUnitByUnit() {
        return unitByUnit;
    }

    public void setUnitByUnit(Unit unitByUnit) {
        this.unitByUnit = unitByUnit;
    }

    @OneToMany(mappedBy = "listingByLId")
    public Collection<Sale> getSalesByLId() {
        return salesByLId;
    }

    public void setSalesByLId(Collection<Sale> salesByLId) {
        this.salesByLId = salesByLId;
    }
}
