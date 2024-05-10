package com.shop.site.Service;
import com.shop.site.DAO.*;
import com.shop.site.Entity.*;
import com.shop.site.DAO.CategoryDAO;
import com.shop.site.Entity.Category;

public class CategorySVC extends CommonSVC<Category, Integer, CategoryDAO>{
    public CategorySVC(){
        super(new CategoryDAO());
    }
    public Category findByName(String name){
        return dao.findByName(name);
    }

}
