package entities;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings("RedundantIfStatement")
@NamedQuery(name = "Status.getAll", query = "SELECT s FROM Status s")
@Entity
public class Status {

    private Integer statusId;
    private String statusName;
    private Collection<Listing> listingsByStatusId;

    @Id
    @Column(name = "status_id", nullable = false)
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "status_name", nullable = false, length = 50)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (statusId != null ? !statusId.equals(status.statusId) : status.statusId != null) return false;
        if (statusName != null ? !statusName.equals(status.statusName) : status.statusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId != null ? statusId.hashCode() : 0;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<Listing> getListingsByStatusId() {
        return listingsByStatusId;
    }

    public void setListingsByStatusId(Collection<Listing> listingsByStatusId) {
        this.listingsByStatusId = listingsByStatusId;
    }
}
