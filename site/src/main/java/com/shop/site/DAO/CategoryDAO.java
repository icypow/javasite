package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;

import com.shop.site.Entity.Category;

public class CategoryDAO extends CommonDAO<Category, Integer> {
    public CategoryDAO(){
        super(Category.class);
    }

}
