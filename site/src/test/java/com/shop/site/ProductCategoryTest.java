package com.shop.site;
import Entity.Order;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

public class ProductCategoryTest {
    static ProductSVC psvc = new ProductSVC();
    static CategorySVC csvc = new CategorySVC();
    static ProductCategorySVC pvsvc = new ProductCategorySVC();

    @Test
    public void testPC(){
        Product p = new Product();
        Category c = new Category();
        psvc.save(p);
        csvc.save(c);
        p = psvc.findAll().get(0);
        c = csvc.findAll().get(0);
        ProductCategoryID id = new ProductCategoryID(p.getProductId(), c.getCategoryId());
        ProductCategory pc = new ProductCategory(p, c, 10);
        pvsvc.save(pc);
        pc = pvsvc.findAll().get(0);
        Assertions.assertEquals(pc.getProduct().getProductId(), p.getProductId());
        Assertions.assertEquals(pc.getCategory().getCategoryId(), c.getCategoryId());
        Assertions.assertEquals(pc.getCategoryPriority(), 10);
        //Assertions.assertEquals(pc.getId(), id);
        Assertions.assertEquals(pvsvc.GetProducts(c).get(0).getProductId(), p.getProductId());
        Assertions.assertEquals(pvsvc.GetCategories(p).get(0).getCategoryId(), c.getCategoryId());
        psvc.delete(p);
        csvc.delete(c);
        pvsvc.delete(pc);
    }



}
