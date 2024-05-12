package com.shop.site.Entity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "Product")
@EqualsAndHashCode
public class Product {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Product_ID")
    private int productId;
    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Product_Price")
    private BigDecimal productPrice;

    @Column(name = "Product_Amount")
    private int productAmount;

    @Column(name = "Product_Description")
    private String productDescription;

    @Column(name = "Relevance")
    private int relevance;


    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductCategory> categories;


    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "product")
    private Set<Review> reviews;


    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "product")
    private Set<OrderProduct> orders;

    public Product(String name, BigDecimal productPrice, int productAmount, String productDescription, int relevance){
        this.productName = name;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productDescription = productDescription;
        this.relevance = relevance;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<OrderProduct> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderProduct> orders) {
        this.orders = orders;
    }


//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product that = (Product) o;
//        return productId == that.getProductId();
//    }
}