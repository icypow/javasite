package com.shop.site;
import com.shop.site.Entity.Client;
import com.shop.site.Entity.Order;
import com.shop.site.Entity.OrderProduct;
import com.shop.site.Entity.Product;
import com.shop.site.Service.ClientSVC;
import com.shop.site.Service.OrderProductSVC;
import com.shop.site.Service.OrderSVC;
import com.shop.site.Service.ProductSVC;
import org.junit.jupiter.api.*;
import com.shop.site.Entity.*;
import com.shop.site.Service.*;

import java.math.BigDecimal;
import java.sql.Date;


public class OrderTest {
    static private OrderProductSVC opsvc = new OrderProductSVC();
    static private ProductSVC psvc = new ProductSVC();
    static private OrderSVC osvc = new OrderSVC();
    static private ClientSVC csvc = new ClientSVC();

    @Test
    public void testAllProducts(){
        Client c = new Client();
        Date date = new Date(2010, 1, 1);
        BigDecimal p = new BigDecimal("250.0");
        Order order = new Order(c, 0, 0, p, date);
        Product product = new Product();
        csvc.save(c);
        osvc.save(order);
        psvc.save(product);
        Order order2 = osvc.findAll().get(0);
        Product product2 = psvc.findAll().get(0);
        Client client2 = csvc.findAll().get(0);
        OrderProduct op = new OrderProduct(order2, product2, 5);
        opsvc.save(op);
        //Order o = new Order();
        //osvc.save(o);
        Assertions.assertEquals(osvc.getProducts(order2).size(), 1);
        //Assertions.assertNull(osvc.getProducts(o));
        osvc.deleteById(order2.getOrderId());
        //osvc.deleteById(o.getOrderId());
        //opsvc.deleteById(new OrderProductID(1,1));
        psvc.deleteById(product2.getProductId());
        csvc.deleteById(client2.getClientId());
    }
}
