package com.shop.site;
import com.shop.site.Entity.Product;
import com.shop.site.Service.ProductSVC;
import org.junit.jupiter.api.*;
import com.shop.site.Entity.*;
import com.shop.site.Service.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {
    static private ProductSVC psvc = new ProductSVC();
    @Test
    public void testProduct(){
        Product p = new Product("Iphone 11", new BigDecimal("25000.0"), 100, "Brand new Apple phone", 10);
        Assertions.assertEquals(p.getProductName(), "Iphone 11");
        Assertions.assertEquals(p.getProductPrice(), new BigDecimal("25000.0"));
        Assertions.assertEquals(p.getProductAmount(), 100);
        Assertions.assertEquals(p.getProductDescription(), "Brand new Apple phone");
        Assertions.assertEquals(p.getRelevance(), 10);
        psvc.save(p);
        Assertions.assertEquals(psvc.findByName("Iphone 11").getProductName(), p.getProductName());
        psvc.delete(p);
    }


}
