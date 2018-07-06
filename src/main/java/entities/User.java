package entities;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@SuppressWarnings("RedundantIfStatement")
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.getByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "User.getAdmin", query = "SELECT u FROM User u WHERE u.role.roleId = 1")
})
@Entity
public class User implements Serializable {

    private Integer userId;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Collection<Sale> purchasesByUserId;
    private Collection<Listing> listingsByUserId;
    private Collection<Wish> wishesByUserId;
    private Collection<Notification> notificationsByUserId;
    private Role role;
    private Contact contact;
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 100, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.replaceAll("\\s+", "");
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 255, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.replaceAll("\\s+", "");
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 50, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.capitalize(name).replaceAll("\\s+", "");
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 50, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = StringUtils.capitalize(surname).replaceAll("\\s+", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "buyer")
    public Collection<Sale> getPurchasesByUserId() {
        return purchasesByUserId;
    }

    public void setPurchasesByUserId(Collection<Sale> purchasesByUserId) {
        this.purchasesByUserId = purchasesByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Listing> getListingsByUserId() {
        return listingsByUserId;
    }

    public void setListingsByUserId(Collection<Listing> listingsByUserId) {
        this.listingsByUserId = listingsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Wish> getWishesByUserId() {
        return wishesByUserId;
    }

    public void setWishesByUserId(Collection<Wish> wishesByUserId) {
        this.wishesByUserId = wishesByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Notification> getNotificationsByUserId() {
        return notificationsByUserId;
    }

    public void setNotificationsByUserId(Collection<Notification> notificationsByUserId) {
        this.notificationsByUserId = notificationsByUserId;
    }

    @Transient
    public boolean isAdmin() {
        return this.role.getRoleId() == 1;
    }

    @Transient
    public boolean isVendor() {
        return this.role.getRoleId() == 2;
    }

    @Transient
    public boolean isClient() {
        return this.role.getRoleId() == 3;
    }

    @Valid
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne(mappedBy = "userByUserId")
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @OneToOne(mappedBy = "userByUserId")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
