package com.shop.site.Service;

import com.shop.site.DAO.OrderProductDAO;
import com.shop.site.Entity.*;

import java.util.List;

public class OrderProductSVC extends CommonSVC<OrderProduct, OrderProductID, OrderProductDAO> {
    public OrderProductSVC(){
        super(new OrderProductDAO());
    }

    public List<Order> GetOrders(Product obj) {return dao.GetOrders(obj);}

    public List<Product> GetProducts(Order obj) {return dao.GetProducts(obj);}

    public void AddToCart(Client client, Product product, int amount) {dao.AddToCart(client, product, amount);}

    public OrderProduct getExactOP(Order order, Product product) {return dao.getExactOP(order, product);}

}
