package com.shop.site.BuisnesLogic;

import com.shop.site.Entity.*;
import com.shop.site.Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
            try {
                sessionFactory = new MetadataSources(registry)
                        .addAnnotatedClasses(Category.class,
                                Client.class,
                                Order.class,
                                OrderProduct.class,
                                Product.class,
                                ProductCategory.class,
                                Review.class
                        )
                        .buildMetadata()
                        .buildSessionFactory();
            }
            catch (Exception e) {
                // StandardServiceRegistryBuilder.destroy(registry);
                // e.printStackTrace();
                throw e;
            }
        }
        return sessionFactory;
    }
}