package Service;

import DAO.OrderProductDAO;
import DAO.ProductCategoryDAO;
import Entity.*;

import java.util.List;

public class ProductCategorySVC extends CommonSVC<ProductCategory, ProductCategoryID, ProductCategoryDAO> {
    public ProductCategorySVC(){
        super(new ProductCategoryDAO());
    }

    public List<Category> GetCategories(Product obj) {return dao.GetCategories(obj);}

    public List<Product> GetProducts(Category obj) {return dao.GetProducts(obj);}

}
