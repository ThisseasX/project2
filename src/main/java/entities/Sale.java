package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@SuppressWarnings("RedundantIfStatement")
@NamedQueries({
        @NamedQuery(name = "Sale.getAll", query = "SELECT s FROM Sale s"),
        @NamedQuery(name = "Sale.getAllByUser", query = "SELECT s FROM Sale s WHERE s.listingByListingId.userByUserId = :user"),
        @NamedQuery(name = "Sale.getAllBetweenDates", query = "SELECT s FROM Sale s WHERE s.saleDate BETWEEN :dateStart AND :dateEnd"),
        @NamedQuery(name = "Sale.getAllByUserBetweenDates", query = "SELECT s FROM Sale s WHERE s.listingByListingId.userByUserId = :user AND s.saleDate BETWEEN :dateStart AND :dateEnd")
})
@Entity
public class Sale {

    private Integer saleId;
    private Integer saleQuantity;
    private Date saleDate;
    private Listing listingByListingId;

    public Sale() {
    }

    public Sale(Listing listingByListingId) {
        this.saleQuantity = listingByListingId.getCartQuantity();
        this.listingByListingId = listingByListingId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_date", nullable = false)
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (saleId != null ? !saleId.equals(sale.saleId) : sale.saleId != null) return false;
        if (saleQuantity != null ? !saleQuantity.equals(sale.saleQuantity) : sale.saleQuantity != null) return false;
        if (saleDate != null ? !saleDate.equals(sale.saleDate) : sale.saleDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saleId != null ? saleId.hashCode() : 0;
        result = 31 * result + (saleQuantity != null ? saleQuantity.hashCode() : 0);
        result = 31 * result + (saleDate != null ? saleDate.hashCode() : 0);
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
