package com.shop.site;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;


public class CategoryTest {
    private CategorySVC csvc = new CategorySVC();

    @Test
    public void testCategory(){
        Category c1 = new Category("Чайник", "Длина, ширина, мощность");
        Assertions.assertEquals(c1.getCategoryName(), "Чайник");
        Assertions.assertEquals(c1.getParameters(), "Длина, ширина, мощность");
    }
}
