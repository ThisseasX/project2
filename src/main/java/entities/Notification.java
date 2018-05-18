package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Notification.getAllByUser", query = "SELECT n.productByProductId FROM Notification n WHERE n.userByUserId = :user"),
        @NamedQuery(name = "Notification.deleteAllByUser", query = "DELETE FROM Notification n WHERE n.userByUserId = :user")
})
@Entity
public class Notification {

    private Integer notificationId;
    private User userByUserId;
    private Product productByProductId;

    public Notification() {
    }

    public Notification(User userByUserId, Product productByProductId) {
        this.userByUserId = userByUserId;
        this.productByProductId = productByProductId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", nullable = false)
    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        return notificationId != null ? notificationId.equals(that.notificationId) : that.notificationId == null;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @Override
    public int hashCode() {
        return notificationId != null ? notificationId.hashCode() : 0;
    }
}
