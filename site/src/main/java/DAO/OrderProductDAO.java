package DAO;

import Entity.*;
import BuisnesLogic.*;
import java.util.List;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderProductDAO extends CommonDAO<OrderProduct, OrderProductID> {
    public OrderProductDAO(){
        super(OrderProduct.class);
    }
    public List<Product> GetProducts(Order obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
//        try {
            StringBuilder queryString = new StringBuilder("SELECT op.product FROM OrderProduct op ");
            queryString.append("WHERE op.order = :order");
            TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
            query.setParameter("order", obj);
            List<Product> res = query.getResultList();
            t.commit();
            return res;
//        }
//        catch (Exception e) {
//            System.out.println("No product allocated to " + obj.getOrderId());
//            t.rollback();
//            return null;
//        }
    }

    public List<Order> GetOrders(Product obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
//        try {
            StringBuilder queryString = new StringBuilder("SELECT op.order FROM OrderProduct op ");
            queryString.append("WHERE op.product = :product");
            TypedQuery<Order> query = session.createQuery(queryString.toString(), Order.class);
            query.setParameter("product", obj);
            List<Order> res = query.getResultList();
            t.commit();
            return res;
//        }
//        catch (Exception e) {
//            System.out.println("No order allocated to " + obj.getProductName());
//            t.rollback();
//            return null;
//        }
    }
}
