package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;
import java.util.List;

import com.shop.site.BuisnesLogic.HibernateUtil;
import com.shop.site.Entity.Order;
import com.shop.site.Entity.OrderProduct;
import com.shop.site.Entity.OrderProductID;
import com.shop.site.Entity.Product;
import com.shop.site.Service.OrderProductSVC;
import com.shop.site.Service.OrderSVC;
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
        try {
            StringBuilder queryString = new StringBuilder("SELECT op.product FROM OrderProduct op ");
            queryString.append("WHERE op.order = :order");
            TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
            query.setParameter("order", obj);
            List<Product> res = query.getResultList();
            t.commit();
            return res;
        }
        catch (Exception e) {
            System.out.println("No product allocated to " + obj.getOrderId());
            t.rollback();
            return null;
        }
    }

    public List<Order> GetOrders(Product obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder("SELECT op.order FROM OrderProduct op ");
            queryString.append("WHERE op.product = :product");
            TypedQuery<Order> query = session.createQuery(queryString.toString(), Order.class);
            query.setParameter("product", obj);
            List<Order> res = query.getResultList();
            t.commit();
            return res;
        }
        catch (Exception e) {
            System.out.println("No order allocated to " + obj.getProductName());
            t.rollback();
            return null;
        }
    }

    public void AddToCart(Client client, Product product, int amount){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder("SELECT Order FROM Order o ");
            queryString.append("WHERE o.client = :client AND o.status = 0");
            TypedQuery<Order> query = session.createQuery(queryString.toString(), Order.class);
            query.setParameter("client", client);
            Order res = query.getSingleResult();
            OrderProduct op = new OrderProduct(res, product, amount);
            this.save(op);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
        }

    }

    public OrderProduct getExactOP(Order order, Product product){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder("SELECT OrderProduct FROM OrderProduct op ");
            queryString.append("WHERE op.product = :product AND op.order = :order");
            TypedQuery<OrderProduct> query = session.createQuery(queryString.toString(), OrderProduct.class);
            query.setParameter("product", product);
            query.setParameter("order", order);
            OrderProduct res = query.getSingleResult();
            t.commit();
            return res;
        }
        catch (Exception e) {
            t.rollback();
            return null;
        }
    }



}
