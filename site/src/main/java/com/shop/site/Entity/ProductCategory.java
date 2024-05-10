package com.shop.site.Entity;
import jakarta.persistence.*;
import com.shop.site.Entity.*;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {

    @EmbeddedId
    private ProductCategoryID id;
    @ManyToOne
    @JoinColumn(name = "Product_ID", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Category_ID", insertable = false, updatable = false)
    private Category category;


    @Column(name = "Category_Priority")
    private int categoryPriority;

    public ProductCategory(Product product, Category category, int categoryPriority) {
        this.product = product;
        this.category = category;
        this.id = new ProductCategoryID(product.getProductId(), category.getCategoryId());
        this.categoryPriority = categoryPriority;
    }

    public ProductCategory() {
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