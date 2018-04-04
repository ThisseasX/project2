package entities;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings("RedundantIfStatement")
@NamedQuery(name = "Type.getAll", query = "SELECT t FROM Type t")
@Entity
public class Type {

    private Integer typeId;
    private String typeName;
    private Category categoryByCategoryId;
    private Collection<Variety> varietiesByTypeId;

    @Id
    @Column(name = "type_id", nullable = false)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        if (typeName != null ? !typeName.equals(type.typeName) : type.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<Variety> getVarietiesByTypeId() {
        return varietiesByTypeId;
    }

    public void setVarietiesByTypeId(Collection<Variety> varietiesByTypeId) {
        this.varietiesByTypeId = varietiesByTypeId;
    }
}
