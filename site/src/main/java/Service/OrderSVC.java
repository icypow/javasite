package Service;
import java.util.List;
import DAO.*;
import Entity.*;
public class OrderSVC extends CommonSVC<Order, OrderDAO>{
    public OrderSVC(){
        super(new OrderDAO());
    }
}
