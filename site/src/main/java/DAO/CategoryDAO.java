package DAO;

import Entity.*;
import BuisnesLogic.*;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAO extends CommonDAO<Category> {
    public CategoryDAO(){
        super(Category.class);
    }


    public List<Product> getProducts(Category obj) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM Product p ");
            queryString.append("FROM Category");
            queryString.append("JOIN ProductCategory ON Category = CategoryProduct.category");
            queryString.append("JOIN Product ON CategoryProduct.product = Product");
            queryString.append("WHERE Category = :CategoryID;");
            TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
            query.setParameter("CategoryID", obj);
            List<Product> res = query.getResultList();
            t.commit();
            return res;
        }
        catch (jakarta.persistence.NoResultException e) {
            System.out.println("No products allocated to " + obj.getCategoryName());
            t.rollback();
            return null;
        }

    }
}
