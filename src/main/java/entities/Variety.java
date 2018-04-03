package entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQuery(name = "Variety.getAll", query = "SELECT v FROM Variety v")
@Entity
public class Variety {

    private Integer varietyId;
    private String varietyName;
    private Collection<Product> productsByVarietyId;
    private Type typeByTypeId;

    @Id
    @Column(name = "variety_id", nullable = false)
    public Integer getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
    }

    @Basic
    @Column(name = "variety_name", nullable = false, length = 50)
    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variety variety = (Variety) o;

        if (varietyId != null ? !varietyId.equals(variety.varietyId) : variety.varietyId != null) return false;
        if (varietyName != null ? !varietyName.equals(variety.varietyName) : variety.varietyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = varietyId != null ? varietyId.hashCode() : 0;
        result = 31 * result + (varietyName != null ? varietyName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "varietyByTypeId")
    public Collection<Product> getProductsByVarietyId() {
        return productsByVarietyId;
    }

    public void setProductsByVarietyId(Collection<Product> productsByVarietyId) {
        this.productsByVarietyId = productsByVarietyId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }
}
