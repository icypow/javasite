package Service;

import DAO.OrderProductDAO;
import Entity.Order;
import Entity.OrderProduct;
import Entity.OrderProductID;
import Entity.Product;

import java.util.List;

public class OrderProductSVC extends CommonSVC<OrderProduct, OrderProductID, OrderProductDAO> {
    public OrderProductSVC(){
        super(new OrderProductDAO());
    }

    public List<Order> GetOrders(Product obj) {return dao.GetOrders(obj);}

    public List<Product> GetProducts(Order obj) {return dao.GetProducts(obj);}


}
