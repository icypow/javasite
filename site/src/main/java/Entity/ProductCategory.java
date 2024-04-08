package Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Product&Category")
public class ProductCategory {
    @ManyToOne
    @JoinColumn(name = "Product_ID",referencedColumnName = "Product_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    private Category category;

    @EmbeddedId
    private ProductCategoryID id;


    @Column(name = "Category_Priority")
    private int categoryPriority;

//    public ProductCategory(Product product, Client client, int rate, String reviewText) {
//        this.rate = rate;
//        this.id = new ReviewID(client.getClientId(), product.getProductId());
//        this.client = client;
//        this.reviewText = reviewText;
//    }
// getters and setters
}