package DAO;

import Entity.*;
import BuisnesLogic.*;
import java.util.List;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO extends CommonDAO<Order, Integer> {
    public OrderDAO() {
        super(Order.class);
    }


    public List<Product> getProducts(Order obj) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        StringBuilder queryString = new StringBuilder("SELECT p FROM Product p ");
        queryString.append("JOIN OrderProduct op ON p = op.product ");
        queryString.append("JOIN Order o ON o = op.order ");
        queryString.append("WHERE o = :Order");
        TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
        query.setParameter("Order", obj);
        List<Product> res = query.getResultList();
        t.commit();
        return res;

//        catch (Exception e) {
//            System.out.println("No products in order " + obj.getOrderId());
//            t.rollback();
//            return null;
//        }
    }




}

