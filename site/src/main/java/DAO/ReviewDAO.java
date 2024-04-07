package DAO;

import Entity.*;
import BuisnesLogic.*;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReviewDAO extends CommonDAO<Review>{
    public ReviewDAO(){
        super(Review.class);
    }
    public void leaveReview(Client clientObj, Product productObj, String text, int rate){
        this.save(new Review(clientObj, productObj, text, rate));
    }

    public List<Review> getProductReviews(Product obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder("SELECT p FROM Product p ");
            TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
            query.setParameter("OrderID", obj.getOrderId());
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
