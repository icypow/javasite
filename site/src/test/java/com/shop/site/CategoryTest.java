package com.shop.site;
import com.shop.site.Entity.Category;
import com.shop.site.Service.CategorySVC;
import org.junit.jupiter.api.*;
import com.shop.site.Entity.*;
import com.shop.site.Service.*;


public class CategoryTest {
    private CategorySVC csvc = new CategorySVC();

    @Test
    public void testCategory(){
        Category c1 = new Category("Чайник", "Длина, ширина, мощность");
        Assertions.assertEquals(c1.getCategoryName(), "Чайник");
        Assertions.assertEquals(c1.getParameters(), "Длина, ширина, мощность");
    }
}
