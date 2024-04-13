package Service;
import java.util.List;
import DAO.*;
import Entity.*;
public class ProductSVC extends CommonSVC<Product, Integer, ProductDAO> {
    public ProductSVC(){
        super(new ProductDAO());
    }
    public Product findByName(String name){
        return dao.findByName(name);
    }
}
