package Entity;
import jakarta.persistence.*;

import java.util.Set;


@Entity

@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_ID")
    private int categoryId;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name = "Parameters")
    private String parameters; // JSON тип данных в Java обычно представлен как String

    @OneToMany(mappedBy = "category")
    private Set<ProductCategory> products;


    public Category(String name){
        this.categoryName = name;
        this.parameters = null;
    }
    public Category(String name, String parameters){
        this.categoryName = name;
        this.parameters = parameters;
    }

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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
}
