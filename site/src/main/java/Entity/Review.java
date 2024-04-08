package Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Review")
public class Review {
    @ManyToOne
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Client_ID", referencedColumnName = "Client_ID")
    private Client client;

    @Column(name = "Rate")
    private int rate;

    @Column(name = "Review_Text")
    private String reviewText;

    @EmbeddedId
    private ReviewID id;

    public Review(Product product, Client client, int rate, String reviewText) {
        this.rate = rate;
        this.id = new ReviewID(client.getClientId(), product.getProductId());
        this.client = client;
        this.reviewText = reviewText;
    }

    public Review(){
    }


}
