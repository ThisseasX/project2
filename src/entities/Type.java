package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Type {
    private Integer typeId;
    private Integer scId;
    private String typeName;
    private Collection<Product> productsByTypeId;
    private Subcategory subcategoryByScId;

    @Id
    @Column(name = "type_id", nullable = false)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "sc_id", nullable = false)
    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    @Basic
    @Column(name = "type_name", nullable = false, length = 50)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (typeId != null ? !typeId.equals(type.typeId) : type.typeId != null) return false;
        if (scId != null ? !scId.equals(type.scId) : type.scId != null) return false;
        if (typeName != null ? !typeName.equals(type.typeName) : type.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (scId != null ? scId.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<Product> getProductsByTypeId() {
        return productsByTypeId;
    }

    public void setProductsByTypeId(Collection<Product> productsByTypeId) {
        this.productsByTypeId = productsByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "sc_id", referencedColumnName = "sc_id", nullable = false)
    public Subcategory getSubcategoryByScId() {
        return subcategoryByScId;
    }

    public void setSubcategoryByScId(Subcategory subcategoryByScId) {
        this.subcategoryByScId = subcategoryByScId;
    }
}
