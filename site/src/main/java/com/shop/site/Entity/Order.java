package com.shop.site.Entity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "OrderTable")
@EqualsAndHashCode
public class Order {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order_ID")
    private int orderId;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "Client_ID")
    private Client client;


    @Column(name = "Status")
    private int status;

    @Column(name = "Delivery_Type")
    private int deliveryType;

    @Column(name = "Delivery_Price")
    private BigDecimal deliveryPrice;

    @Column(name = "Delivery_date")
    private Date deliveryDate;

    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderProduct> products;

    public Order() {
    }

    public Order(Client client, int status, int deliveryType, BigDecimal deliveryPrice, java.sql.Date deliveryDate){
        this.client = client;
        this.status = status;
        this.deliveryType = deliveryType;
        this.deliveryPrice = deliveryPrice;
        this.deliveryDate = deliveryDate;
    }

    public Order(Client client, int i) {

    }

    public String toString(){
        return "Client "+client+" ID"+orderId;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.products = orderProducts;
    }

    public Set<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<OrderProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return orderId == that.getOrderId();
    }
}
