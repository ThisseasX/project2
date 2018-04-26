package entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@SuppressWarnings("RedundantIfStatement")
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.getByUsername", query = "SELECT u FROM User u where u.username = :username")
})
@Entity
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Collection<Account> accountsByUserId;
    private Collection<Contact> contactsByUserId;
    private Collection<Listing> listingsByUserId;
    private Role role;

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
    @Size(max = 50, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 50, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 50, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Must not be empty!")
    @Size(max = 50, message = "Cannot exceed {max} characters!")
    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Account> getAccountsByUserId() {
        return accountsByUserId;
    }

    public void setAccountsByUserId(Collection<Account> accountsByUserId) {
        this.accountsByUserId = accountsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Contact> getContactsByUserId() {
        return contactsByUserId;
    }

    public void setContactsByUserId(Collection<Contact> contactsByUserId) {
        this.contactsByUserId = contactsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Listing> getListingsByUserId() {
        return listingsByUserId;
    }

    public void setListingsByUserId(Collection<Listing> listingsByUserId) {
        this.listingsByUserId = listingsByUserId;
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
}
