package Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Product&Category")
public class ProductCategory {
    @Id
    @ManyToOne
    @JoinColumn(name = "Product_ID",referencedColumnName = "Product_ID")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    private Category category;

    @Column(name = "Category_Priority")
    private int categoryPriority;

// getters and setters
}