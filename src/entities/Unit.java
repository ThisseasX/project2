package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Unit {
    private Integer unitId;
    private String unitName;
    private Collection<Listing> listingsByUnitId;

    @Id
    @Column(name = "unit_id", nullable = false)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unit_name", nullable = false, length = 50)
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (unitId != null ? !unitId.equals(unit.unitId) : unit.unitId != null) return false;
        if (unitName != null ? !unitName.equals(unit.unitName) : unit.unitName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId != null ? unitId.hashCode() : 0;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitByUnit")
    public Collection<Listing> getListingsByUnitId() {
        return listingsByUnitId;
    }

    public void setListingsByUnitId(Collection<Listing> listingsByUnitId) {
        this.listingsByUnitId = listingsByUnitId;
    }
}
