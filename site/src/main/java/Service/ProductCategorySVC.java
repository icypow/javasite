package Service;

import DAO.OrderProductDAO;
import DAO.ProductCategoryDAO;
import Entity.OrderProduct;
import Entity.ProductCategory;

public class ProductCategorySVC extends CommonSVC<ProductCategory, ProductCategoryDAO> {
    public ProductCategorySVC(){
        super(new ProductCategoryDAO());
    }
}
