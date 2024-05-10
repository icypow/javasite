package com.shop.site.Service;

import com.shop.site.DAO.OrderProductDAO;
import com.shop.site.Entity.Order;
import com.shop.site.Entity.OrderProduct;
import com.shop.site.Entity.OrderProductID;
import com.shop.site.Entity.Product;

import java.util.List;

public class OrderProductSVC extends CommonSVC<OrderProduct, OrderProductID, OrderProductDAO> {
    public OrderProductSVC(){
        super(new OrderProductDAO());
    }

    public List<Order> GetOrders(Product obj) {return dao.GetOrders(obj);}

    public List<Product> GetProducts(Order obj) {return dao.GetProducts(obj);}


}
