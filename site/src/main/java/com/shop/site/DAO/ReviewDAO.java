package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;

import com.shop.site.BuisnesLogic.HibernateUtil;
import com.shop.site.Entity.Client;
import com.shop.site.Entity.Product;
import com.shop.site.Entity.Review;
import com.shop.site.Entity.ReviewID;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReviewDAO extends CommonDAO<Review, ReviewID>{
    public ReviewDAO(){
        super(Review.class);
    }
    public void leaveReview(Client clientObj, Product productObj, String text, int rate){
        this.save(new Review(productObj, clientObj, rate, text));
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
        catch (Exception e) {
            System.out.println("No reviews allocated to " + obj.getProductName());
            t.rollback();
            return null;
        }
    }

}
