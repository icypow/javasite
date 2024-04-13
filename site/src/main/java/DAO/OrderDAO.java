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
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM Product p ");
            queryString.append("WHERE FROM Order");
            queryString.append("JOIN OrderProduct ON Order = OrderProduct.order");
            queryString.append("JOIN Product ON OrderProduct = Product.product");
            queryString.append("WHERE Order = :Order;");
            TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
            query.setParameter("OrderID", obj);
            List<Product> res = query.getResultList();
            t.commit();
            return res;
        }

        catch (jakarta.persistence.NoResultException e) {
            System.out.println("No products in order " + obj.getOrderId());
            t.rollback();
            return null;
        }
    }




}

