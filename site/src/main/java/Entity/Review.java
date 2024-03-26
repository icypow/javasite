package Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Review")
public class Review {
    @Id
    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "Client_ID")
    private Client client;

    @Column(name = "Rate")
    private int rate;

    @Column(name = "Review_Text")
    private String reviewText;
}