package entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "Product&Category")
public class ProductCategory {
    @Id
    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "Category_ID")
    private Category category;

    @Column(name = "Category_Priority")
    private int categoryPriority;

// getters and setters
}