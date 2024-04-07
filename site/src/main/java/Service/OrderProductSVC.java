package Service;

import DAO.OrderProductDAO;
import Entity.OrderProduct;

public class OrderProductSVC extends CommonSVC<OrderProduct, OrderProductDAO> {
    public OrderProductSVC(){
        super(new OrderProductDAO());
    }
}
