package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
    private Integer rId;
    private String rName;
    private Collection<User> usersByRId;

    @Id
    @Column(name = "r_id", nullable = false)
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "r_name", nullable = false, length = 50)
    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (rId != null ? !rId.equals(role.rId) : role.rId != null) return false;
        if (rName != null ? !rName.equals(role.rName) : role.rName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rId != null ? rId.hashCode() : 0;
        result = 31 * result + (rName != null ? rName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRole")
    public Collection<User> getUsersByRId() {
        return usersByRId;
    }

    public void setUsersByRId(Collection<User> usersByRId) {
        this.usersByRId = usersByRId;
    }
}
