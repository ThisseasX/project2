package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@SuppressWarnings("RedundantIfStatement")
@NamedQueries({
        @NamedQuery(name = "Listing.getAll", query = "SELECT l FROM Listing l"),
        @NamedQuery(name = "Listing.getAllAvailable", query = "SELECT l FROM Listing l WHERE l.statusByStatusId.statusId = 1"),
        @NamedQuery(name = "Listing.getAllInactive", query = "SELECT l FROM Listing l WHERE l.statusByStatusId.statusId = 2"),
        @NamedQuery(name = "Listing.getAllDepleted", query = "SELECT l FROM Listing l WHERE l.statusByStatusId.statusId = 3"),
        @NamedQuery(name = "Listing.getAllPending", query = "SELECT l FROM Listing l WHERE l.statusByStatusId.statusId = 4"),
        @NamedQuery(name = "Listing.getByProductId", query = "SELECT l FROM Listing l WHERE l.productByProductId.productId = :id"),
        @NamedQuery(name = "Listing.getAvailableByProductId", query = "SELECT l FROM Listing l WHERE l.productByProductId.productId = :id AND l.statusByStatusId.statusId = 1")
})
@Entity
public class Listing {

    private Integer listingId;
    private Integer listingQuantity;
    private Integer pricePerUnit;
    private String listingName;
    private Timestamp listingDate;
    private Product productByProductId;
    private User userByUserId;
    private Status statusByStatusId;
    private Unit unitByUnitId;
    private Collection<Sale> salesByListingId;

    private int cartQuantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listing_id", nullable = false)
    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    @Basic
    @Column(name = "listing_quantity", nullable = false)
    public Integer getListingQuantity() {
        return listingQuantity;
    }

    public void setListingQuantity(Integer listingQuantity) {
        this.listingQuantity = listingQuantity;
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
    @Column(name = "listing_name", nullable = false)
    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    @Basic
    @Column(name = "listing_date", nullable = false)
    public Timestamp getListingDate() {
        return listingDate;
    }

    public void setListingDate(Timestamp listingDate) {
        this.listingDate = listingDate;
    }

    @Transient
    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        if (listingId != null ? !listingId.equals(listing.listingId) : listing.listingId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return listingId != null ? listingId.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false)
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false)
    public Unit getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(Unit unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "listingByListingId")
    public Collection<Sale> getSalesByListingId() {
        return salesByListingId;
    }

    public void setSalesByListingId(Collection<Sale> salesByListingId) {
        this.salesByListingId = salesByListingId;
    }
}
