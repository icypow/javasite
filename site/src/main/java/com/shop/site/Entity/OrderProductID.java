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
}
