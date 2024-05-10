package com.shop.site.DAO;

import com.shop.site.BuisnesLogic.HibernateUtil;
import com.shop.site.Entity.Category;
import com.shop.site.Entity.Product;
import com.shop.site.Entity.ProductCategory;
import com.shop.site.Entity.ProductCategoryID;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductCategoryDAO extends CommonDAO<ProductCategory, ProductCategoryID> {
    public ProductCategoryDAO(){
        super(ProductCategory.class);
    }

    public List<Product> GetProducts(Category obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
//        try {
            StringBuilder queryString = new StringBuilder("SELECT op.product FROM ProductCategory op ");
            queryString.append("WHERE op.category = :category");
            TypedQuery<Product> query = session.createQuery(queryString.toString(), Product.class);
            query.setParameter("category", obj);
            List<Product> res = query.getResultList();
            t.commit();
            return res;
//        }
//        catch (Exception e) {
//            System.out.println("No products allocated to " + obj.getCategoryName());
//            t.rollback();
//            return null;
//        }
    }

    public List<Category> GetCategories(Product obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
//        try {
            StringBuilder queryString = new StringBuilder("SELECT op.category FROM ProductCategory op ");
            queryString.append("WHERE op.product = :product");
            TypedQuery<Category> query = session.createQuery(queryString.toString(), Category.class);
            query.setParameter("product", obj);
            List<Category> res = query.getResultList();
            t.commit();
            return res;
//}
//        catch (Exception e) {
//            System.out.println("No category allocated to " + obj.getProductName());
//            t.rollback();
//            return null;
//        }
    }


}