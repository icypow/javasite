package entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;


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