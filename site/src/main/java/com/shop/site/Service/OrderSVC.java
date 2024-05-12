package com.shop.site.Service;
import java.util.List;
import com.shop.site.DAO.*;
import com.shop.site.Entity.*;
import com.shop.site.DAO.OrderDAO;
import com.shop.site.Entity.Order;
import com.shop.site.Entity.Product;

public class OrderSVC extends CommonSVC<Order, Integer, OrderDAO>{
    public OrderSVC(){
        super(new OrderDAO());
    }
    public List<Product> getProducts(Order obj) { return dao.getProducts(obj); }

    public List<OrderProduct> getOrderProducts(Order obj) {return dao.getOrderProducts(obj); }
}
