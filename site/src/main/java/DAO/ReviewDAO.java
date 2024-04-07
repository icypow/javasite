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
            StringBuilder queryString = new StringBuilder("SELECT r FROM Review r ");
            queryString.append("WHERE r.product = :product");
            TypedQuery<Review> query = session.createQuery(queryString.toString(), Review.class);
            query.setParameter("product", obj);
            List<Review> res = query.getResultList();
            t.commit();
            return res;
        }
        catch (jakarta.persistence.NoResultException e) {
            System.out.println("No reviews allocated to " + obj.getProductName());
            t.rollback();
            return null;
        }
    }

}
