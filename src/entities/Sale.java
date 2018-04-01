package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Sale {
    private Integer saleId;
    private Integer lId;
    private Integer quantity;
    private Timestamp date;
    private Byte paid;
    private Listing listingByLId;

    @Id
    @Column(name = "sale_id", nullable = false)
    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    @Basic
    @Column(name = "l_id", nullable = false)
    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
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
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "paid", nullable = false)
    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (saleId != null ? !saleId.equals(sale.saleId) : sale.saleId != null) return false;
        if (lId != null ? !lId.equals(sale.lId) : sale.lId != null) return false;
        if (quantity != null ? !quantity.equals(sale.quantity) : sale.quantity != null) return false;
        if (date != null ? !date.equals(sale.date) : sale.date != null) return false;
        if (paid != null ? !paid.equals(sale.paid) : sale.paid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saleId != null ? saleId.hashCode() : 0;
        result = 31 * result + (lId != null ? lId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "l_id", referencedColumnName = "l_id", nullable = false)
    public Listing getListingByLId() {
        return listingByLId;
    }

    public void setListingByLId(Listing listingByLId) {
        this.listingByLId = listingByLId;
    }
}
