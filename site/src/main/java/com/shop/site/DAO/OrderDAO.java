package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;
import java.util.List;

import com.shop.site.BuisnesLogic.HibernateUtil;
import com.shop.site.Entity.Order;
import com.shop.site.Entity.Product;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO extends CommonDAO<Order, Integer> {
    public OrderDAO() {
        super(Order.class);
    }


    public List<Product> getProducts(Order obj) {
        try {
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
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
//        catch (Exception e) {
//            System.out.println("No products in order " + obj.getOrderId());
//            t.rollback();
//            return null;
//        }
    }




}

