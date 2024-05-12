package com.shop.site.Entity;

public class CartItemDTO {
    private OrderProduct orderProduct;
    private Product product;

    public CartItemDTO(OrderProduct orderProduct, Product product) {
        this.orderProduct = orderProduct;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }
}
