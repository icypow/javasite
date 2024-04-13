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
        try {
            Product p = session.createQuery("FROM Product WHERE productName = :name", Product.class).setParameter("name", name).getSingleResult();
            transaction.commit();
            return p;
        } catch (jakarta.persistence.NoResultException e) {
            System.out.println("Not found product with name " + name);
            transaction.rollback();
            return null;
        }
    }
}
