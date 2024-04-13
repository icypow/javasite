package com.shop.site;
import Entity.Order;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderProductTest {
    static private OrderProductSVC opsvc = new OrderProductSVC();
    static private ProductSVC psvc = new ProductSVC();
    static private OrderSVC osvc = new OrderSVC();
    static private ClientSVC csvc = new ClientSVC();


    @Test
    public void testOP(){
        Client c = new Client();
        csvc.save(c);
        Date date = new Date(2010, 1, 1);
        BigDecimal p = new BigDecimal("250.0");
        Client client2 = csvc.findAll().get(0);
        Order order = new Order(client2, 0, 0, p, date);
        Product product = new Product();
        osvc.save(order);
        psvc.save(product);
        Order order2 = osvc.findAll().get(0);
        System.out.println(order2.getClient().getClientId());
        System.out.println(client2.getClientId());
        Product product2 = psvc.findAll().get(0);
        OrderProduct op = new OrderProduct(order2, product2, 5);
        opsvc.save(op);
        System.out.println(opsvc.findAll().get(0).getOrder().toString());
        System.out.println(order2.toString());
        Assertions.assertEquals(opsvc.findAll().get(0).getOrder().getOrderId(), order2.getOrderId());
        Assertions.assertEquals(opsvc.findAll().get(0).getProduct().getProductId(), product2.getProductId());
        Assertions.assertEquals(opsvc.findAll().get(0).getPoAmount(), 5);
        Assertions.assertEquals(opsvc.GetOrders(product2).get(0).getOrderId(), order2.getOrderId());
        Assertions.assertEquals(opsvc.GetProducts(order2).get(0).getProductId(), product2.getProductId());
        osvc.deleteById(order2.getOrderId());
        psvc.deleteById(product2.getProductId());
        csvc.deleteById(client2.getClientId());

    }


}
