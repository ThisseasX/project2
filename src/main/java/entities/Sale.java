package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@NamedQuery(name = "Sale.getAll", query = "SELECT s FROM Sale s")
@Entity
public class Sale {

    private Integer saleId;
    private Integer saleQuantity;
    private Timestamp saleDate;
    private Byte paid;
    private Listing listingByListingId;

    @Id
    @Column(name = "sale_id", nullable = false)
    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    @Basic
    @Column(name = "sale_quantity", nullable = false)
    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    @Basic
    @Column(name = "sale_date", nullable = false)
    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
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
        if (saleQuantity != null ? !saleQuantity.equals(sale.saleQuantity) : sale.saleQuantity != null) return false;
        if (saleDate != null ? !saleDate.equals(sale.saleDate) : sale.saleDate != null) return false;
        if (paid != null ? !paid.equals(sale.paid) : sale.paid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saleId != null ? saleId.hashCode() : 0;
        result = 31 * result + (saleQuantity != null ? saleQuantity.hashCode() : 0);
        result = 31 * result + (saleDate != null ? saleDate.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "listing_id", referencedColumnName = "listing_id", nullable = false)
    public Listing getListingByListingId() {
        return listingByListingId;
    }

    public void setListingByListingId(Listing listingByListingId) {
        this.listingByListingId = listingByListingId;
    }
}
