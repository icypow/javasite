package com.shop.site;
import Entity.Order;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

import java.math.BigDecimal;
import java.sql.Date;


public class OrderTest {
    static private OrderProductSVC opsvc = new OrderProductSVC();
    static private ProductSVC psvc = new ProductSVC();
    static private OrderSVC osvc = new OrderSVC();
    static private ClientSVC csvc = new ClientSVC();

    @BeforeAll
    static public void testOrder(){
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
        OrderProduct op = new OrderProduct(order2, product2, 5);
        opsvc.save(op);
    }

    @Test
    public void testAllProducts(){
        Assertions.assertEquals(osvc.getProducts(osvc.findById(1)).size(), 1);
    }
    @AfterAll
    static public void testOrderAfter(){
        osvc.deleteById(1);
        opsvc.deleteById(1);
        psvc.deleteById(1);
    }
}
