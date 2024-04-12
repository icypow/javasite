package Entity;
import jakarta.persistence.*;
import Entity.*;
import Entity.Order;

@Entity
@Table(name = "Order&Product")
public class OrderProduct {
    @ManyToOne
    @JoinColumn(name = "Order_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Product product;

    @EmbeddedId
    private OrderProductID id;

    @Column(name = "P&O_Amount")
    private int poAmount;

    public OrderProduct(Order order, Product product, int poAmount){
        this.order = order;
        this.product = product;
        this.poAmount = poAmount;
        this.id = new OrderProductID(order.getOrderId(), product.getProductId());

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderProductID getId() {
        return id;
    }

    public void setId(OrderProductID id) {
        this.id = id;
    }

    public int getPoAmount() {
        return poAmount;
    }

    public void setPoAmount(int poAmount) {
        this.poAmount = poAmount;
    }
}





