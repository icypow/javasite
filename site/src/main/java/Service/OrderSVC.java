package Service;
import java.util.List;
import DAO.*;
import Entity.*;
public class OrderSVC extends CommonSVC<Order, Integer, OrderDAO>{
    public OrderSVC(){
        super(new OrderDAO());
    }
    public List<Product> getProducts(Order obj) { return dao.getProducts(obj); }

}
