package com.shop.site;
import Entity.Order;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

public class OrderProductTest {
    @Test
    public void testOP(){
        Order o = new Order();
        Product p = new Product();
        OrderProductID id = new OrderProductID(o.getOrderId(), p.getProductId());
        OrderProduct op = new OrderProduct(o, p, 1);
        Assertions.assertEquals(op.getOrder(), o);
        Assertions.assertEquals(op.getProduct(), p);
        Assertions.assertEquals(op.getPoAmount(), 1);
        //Assertions.assertEquals(op.getId(), id);

    }


}
