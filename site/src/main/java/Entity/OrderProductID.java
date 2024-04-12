package Entity;


import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.io.Serializable;
@Embeddable
public class OrderProductID implements Serializable{
    private int order_id;
    private int product_id;


    public OrderProductID(){};
    public OrderProductID(int order, int product){
        this.product_id = product;
        this.order_id = order;
    }
}
