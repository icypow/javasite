package entity;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name = "Parametres")
    private String parametres; // JSON тип данных в Java обычно представлен как String

    @OneToMany(mappedBy = "category")
    private Set<ProductCategory> productCategories;

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParametres() {
        return parametres;
    }

    public void setParametres(String parametres) {
        this.parametres = parametres;
    }

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }
}