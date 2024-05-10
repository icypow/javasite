package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;

import com.shop.site.BuisnesLogic.HibernateUtil;
import com.shop.site.Entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class ProductDAO extends CommonDAO<Product, Integer> {
    public ProductDAO(){
        super(Product.class);
    }

    public Product findByName(String name) {

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Product p = session.createQuery("FROM Product WHERE productName = :name", Product.class).setParameter("name", name).getSingleResult();
            transaction.commit();
            return p;
        }
        catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
}
