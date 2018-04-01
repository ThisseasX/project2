package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private Integer uId;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Integer role;
    private Collection<Account> accountsByUId;
    private Collection<Contact> contactsByUId;
    private Collection<Listing> listingsByUId;
    private Role roleByRole;

    @Id
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uId != null ? !uId.equals(user.uId) : user.uId != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId != null ? uId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUId")
    public Collection<Account> getAccountsByUId() {
        return accountsByUId;
    }

    public void setAccountsByUId(Collection<Account> accountsByUId) {
        this.accountsByUId = accountsByUId;
    }

    @OneToMany(mappedBy = "userByUId")
    public Collection<Contact> getContactsByUId() {
        return contactsByUId;
    }

    public void setContactsByUId(Collection<Contact> contactsByUId) {
        this.contactsByUId = contactsByUId;
    }

    @OneToMany(mappedBy = "userByUId")
    public Collection<Listing> getListingsByUId() {
        return listingsByUId;
    }

    public void setListingsByUId(Collection<Listing> listingsByUId) {
        this.listingsByUId = listingsByUId;
    }

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "r_id", nullable = false)
    public Role getRoleByRole() {
        return roleByRole;
    }

    public void setRoleByRole(Role roleByRole) {
        this.roleByRole = roleByRole;
    }
}
