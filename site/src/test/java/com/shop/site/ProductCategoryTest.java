package com.shop.site;
import Entity.Order;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

public class ProductCategoryTest {
    @Test
    public void testPC(){
        Product p = new Product();
        Category c = new Category();
        ProductCategoryID id = new ProductCategoryID(p.getProductId(), c.getCategoryId());
        ProductCategory pc = new ProductCategory(p, c, 10);
        Assertions.assertEquals(pc.getProduct(), p);
        Assertions.assertEquals(pc.getCategory(), c);
        Assertions.assertEquals(pc.getCategoryPriority(), 10);
        //Assertions.assertEquals(pc.getId(), id);

    }



}
