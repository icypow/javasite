package com.shop.site.Entity;
import jakarta.persistence.*;

import java.util.Set;


@Entity

@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Category_ID")
    private int categoryId;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name = "Parametrs")
    private String parametrs; // JSON тип данных в Java обычно представлен как String

    @OneToMany(mappedBy = "category")
    private Set<ProductCategory> products;


    public Category(String name){
        this.categoryName = name;
        this.parametrs = null;
    }
    public Category(String name, String parametrs){
        this.categoryName = name;
        this.parametrs = parametrs;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getparametrs() {
        return parametrs;
    }

    public void setparametrs(String parametrs) {
        this.parametrs = parametrs;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
}
