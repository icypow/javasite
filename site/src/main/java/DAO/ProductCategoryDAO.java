package DAO;

import Entity.ProductCategory;

public class ProductCategoryDAO extends CommonDAO<ProductCategory> {
    public ProductCategoryDAO(){
        super(ProductCategory.class);
    }
}