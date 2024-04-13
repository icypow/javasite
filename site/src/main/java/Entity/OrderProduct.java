package Entity;
import jakarta.persistence.*;
import Entity.*;
import Entity.Order;
import lombok.*;
@Entity
@Table(name = "OrderProduct")
@NoArgsConstructor
public class OrderProduct {

    @EmbeddedId
    private OrderProductID id;
    @ManyToOne
    @JoinColumn(name = "Order_ID", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "Product_ID", insertable = false, updatable = false)
    private Product product;

    @Column(name = "Amount")
    private int poAmount;

    public OrderProduct(Order order, Product product, int poAmount){
        this.order = order;
        this.product = product;
        this.poAmount = poAmount;
        this.id = new OrderProductID(order.getOrderId(), product.getProductId());
    }

    public OrderProduct() {

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





