package entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "Product_Price")
    private BigDecimal productPrice;

    @Column(name = "Product_Amount")
    private int productAmount;

    @Column(name = "Product_Description")
    private String productDescription;

    @Column(name = "Relevance")
    private int relevance;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "ProductCategories",
            joinColumns = @JoinColumn(name = "Product_ID"),
            inverseJoinColumns = @JoinColumn(name =  "Category_ID")
    )
    private Set<Category> categories;
    @ManyToMany(mappedBy = "products")
    private Set<Client> clients;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public Set<Categories> getProductCategories() {
        return Categories;
    }

    public void setProductCategories(Set<Categories> productCategories) {
        this.Categories = productCategories;
    }