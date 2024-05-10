package DAO;

import Entity.*;
import BuisnesLogic.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class ProductDAO extends CommonDAO<Product, Integer> {
    public ProductDAO(){
        super(Product.class);
    }

    public Product findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
            Product p = session.createQuery("FROM Product WHERE productName = :name", Product.class).setParameter("name", name).getSingleResult();
            transaction.commit();
            return p;
    }
}
