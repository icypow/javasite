package com.shop.site.Service;

import com.shop.site.DAO.ProductCategoryDAO;
import com.shop.site.Entity.*;
import com.shop.site.Entity.Category;
import com.shop.site.Entity.Product;
import com.shop.site.Entity.ProductCategory;
import com.shop.site.Entity.ProductCategoryID;

import java.util.List;

public class ProductCategorySVC extends CommonSVC<ProductCategory, ProductCategoryID, ProductCategoryDAO> {
    public ProductCategorySVC(){
        super(new ProductCategoryDAO());
    }

    public List<Category> GetCategories(Product obj) {return dao.GetCategories(obj);}

    public List<Product> GetProducts(Category obj) {return dao.GetProducts(obj);}

}
