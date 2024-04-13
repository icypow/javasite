package Service;

import DAO.OrderProductDAO;
import DAO.ProductCategoryDAO;
import Entity.OrderProduct;
import Entity.ProductCategory;
import Entity.ProductCategoryID;

public class ProductCategorySVC extends CommonSVC<ProductCategory, ProductCategoryID, ProductCategoryDAO> {
    public ProductCategorySVC(){
        super(new ProductCategoryDAO());
    }
}
