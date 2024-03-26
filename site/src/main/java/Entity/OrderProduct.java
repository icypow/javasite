package Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Order&Product")
public class OrderProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "Order_ID")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Product product;

    @Column(name = "P&O_Amount")
    private int poAmount;

// getters and setters
}





