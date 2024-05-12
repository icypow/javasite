package com.shop.site.Entity;


import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.io.Serializable;
@Embeddable
public class OrderProductID implements Serializable{

    private int Order_ID;
    private int Product_ID;


    public OrderProductID(){};
    public OrderProductID(int order, int product){
        this.Product_ID = product;
        this.Order_ID = order;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int product_ID) {
        Product_ID = product_ID;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int order_ID) {
        Order_ID = order_ID;
    }
}
