package com.shop.site.Service;
import com.shop.site.DAO.*;
import com.shop.site.Entity.*;
import com.shop.site.DAO.ProductDAO;
import com.shop.site.Entity.Product;

public class ProductSVC extends CommonSVC<Product, Integer, ProductDAO> {
    public ProductSVC(){
        super(new ProductDAO());
    }
    public Product findByName(String name){
        return dao.findByName(name);
    }
}
