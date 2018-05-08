package entities;

import javax.persistence.*;

@NamedQuery(name = "Wish.getByUserId", query = "SELECT w FROM Wish w WHERE w.userByUserId.userId = :id")
@Entity
public class Wish {

    private Integer wishId;
    private User userByUserId;
    private Product productByProductId;

    @Id
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

        return wishId != null ? wishId.equals(wish.wishId) : wish.wishId == null;
    }

    @Override
    public int hashCode() {
        return wishId != null ? wishId.hashCode() : 0;
    }
}
