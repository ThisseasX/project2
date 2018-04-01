package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    private Integer catId;
    private String catName;
    private Collection<Subcategory> subcategoriesByCatId;

    @Id
    @Column(name = "cat_id", nullable = false)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "cat_name", nullable = false, length = 50)
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (catId != null ? !catId.equals(category.catId) : category.catId != null) return false;
        if (catName != null ? !catName.equals(category.catName) : category.catName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId != null ? catId.hashCode() : 0;
        result = 31 * result + (catName != null ? catName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByCatId")
    public Collection<Subcategory> getSubcategoriesByCatId() {
        return subcategoriesByCatId;
    }

    public void setSubcategoriesByCatId(Collection<Subcategory> subcategoriesByCatId) {
        this.subcategoriesByCatId = subcategoriesByCatId;
    }
}
