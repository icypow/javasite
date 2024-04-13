package Service;

import DAO.OrderProductDAO;
import Entity.OrderProduct;
import Entity.OrderProductID;

public class OrderProductSVC extends CommonSVC<OrderProduct, OrderProductID, OrderProductDAO> {
    public OrderProductSVC(){
        super(new OrderProductDAO());
    }
}
