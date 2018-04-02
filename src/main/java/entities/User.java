package entities;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
@Entity
public class User {

    private Integer uId;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Integer role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Size(min = 1, max = 50, message = "Must be within {min} and {max} characters long!")
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 1, max = 50, message = "Must be within {min} and {max} characters long!")
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Size(min = 1, max = 50, message = "Must be within {min} and {max} characters long!")
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 1, max = 50, message = "Must be between {min} and {max} characters long!")
    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotNull(message = "Must not be empty!")
    @Range(min = 1, max = 3, message = "Must be between {min} and {max}!")
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

        return (uId != null ? uId.equals(user.uId) : user.uId == null) &&
                (username != null ? username.equals(user.username) : user.username == null) &&
                (password != null ? password.equals(user.password) : user.password == null) &&
                (name != null ? name.equals(user.name) : user.name == null) &&
                (surname != null ? surname.equals(user.surname) : user.surname == null) &&
                (role != null ? role.equals(user.role) : user.role == null);
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
}
