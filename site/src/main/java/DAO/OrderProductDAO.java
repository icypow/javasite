package DAO;

import Entity.*;
import BuisnesLogic.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderProductDAO extends CommonDAO<OrderProduct> {
    public OrderProductDAO(){
        super(OrderProduct.class);
    }
}
