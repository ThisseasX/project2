package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Wish.exists", query = "SELECT w FROM Wish w WHERE w.userByUserId = :user AND w.productByProductId = :product"),
        @NamedQuery(name = "Wish.getAllByProduct", query = "SELECT w.userByUserId FROM Wish w WHERE w.productByProductId = :product")
})
@Entity
public class Wish {

    private Integer wishId;
    private User userByUserId;
    private Product productByProductId;

    public Wish() {
    }

    public Wish(User userByUserId, Product productByProductId) {
        this.userByUserId = userByUserId;
        this.productByProductId = productByProductId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_id", nullable = false)
    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
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
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish = (Wish) o;

        return (userByUserId != null ? userByUserId.equals(wish.userByUserId) : wish.userByUserId == null)
                && (productByProductId != null ? productByProductId.equals(wish.productByProductId) : wish.productByProductId == null);
    }

    @Override
    public int hashCode() {
        int result = userByUserId != null ? userByUserId.hashCode() : 0;
        result = 31 * result + (productByProductId != null ? productByProductId.hashCode() : 0);
        return result;
    }
}
