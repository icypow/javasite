package Entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import Entity.*;

@Entity
@Table(name = "Product&Category")
public class ProductCategory {
    @ManyToOne
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    private Category category;

    @EmbeddedId
    private ProductCategoryID id;


    @Column(name = "Category_Priority")
    private int categoryPriority;

    public ProductCategory(Product product, Category category, int categoryPriority) {
        this.product = product;
        this.category = category;
        this.id = new ProductCategoryID(product.getProductId(), category.getCategoryId());
        this.categoryPriority = categoryPriority;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductCategoryID getId() {
        return id;
    }

    public void setId(ProductCategoryID id) {
        this.id = id;
    }

    public int getCategoryPriority() {
        return categoryPriority;
    }

    public void setCategoryPriority(int categoryPriority) {
        this.categoryPriority = categoryPriority;
    }
}