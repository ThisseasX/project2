package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Status {
    private Integer sId;
    private String sName;
    private Collection<Listing> listingsBySId;

    @Id
    @Column(name = "s_id", nullable = false)
    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_name", nullable = false, length = 50)
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (sId != null ? !sId.equals(status.sId) : status.sId != null) return false;
        if (sName != null ? !sName.equals(status.sName) : status.sName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId != null ? sId.hashCode() : 0;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statusByStatus")
    public Collection<Listing> getListingsBySId() {
        return listingsBySId;
    }

    public void setListingsBySId(Collection<Listing> listingsBySId) {
        this.listingsBySId = listingsBySId;
    }
}
