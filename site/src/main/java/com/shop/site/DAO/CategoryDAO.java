package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;

import com.shop.site.Entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDAO extends CommonDAO<Category, Integer> {
    public CategoryDAO(){
        super(Category.class);
    }

    public Category findByName(String name) {
        try{Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Category p = session.createQuery("FROM Category WHERE categoryName = :name", Category.class).setParameter("name", name).getSingleResult();
        transaction.commit();
        return p;
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

}
