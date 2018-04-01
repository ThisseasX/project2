package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Subcategory {
    private Integer scId;
    private Integer catId;
    private String scName;
    private Category categoryByCatId;
    private Collection<Type> typesByScId;

    @Id
    @Column(name = "sc_id", nullable = false)
    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    @Basic
    @Column(name = "cat_id", nullable = false)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "sc_name", nullable = false, length = 50)
    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subcategory that = (Subcategory) o;

        if (scId != null ? !scId.equals(that.scId) : that.scId != null) return false;
        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;
        if (scName != null ? !scName.equals(that.scName) : that.scName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scId != null ? scId.hashCode() : 0;
        result = 31 * result + (catId != null ? catId.hashCode() : 0);
        result = 31 * result + (scName != null ? scName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id", nullable = false)
    public Category getCategoryByCatId() {
        return categoryByCatId;
    }

    public void setCategoryByCatId(Category categoryByCatId) {
        this.categoryByCatId = categoryByCatId;
    }

    @OneToMany(mappedBy = "subcategoryByScId")
    public Collection<Type> getTypesByScId() {
        return typesByScId;
    }

    public void setTypesByScId(Collection<Type> typesByScId) {
        this.typesByScId = typesByScId;
    }
}
