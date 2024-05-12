package com.shop.site.DAO;

import com.shop.site.Entity.*;
import com.shop.site.BuisnesLogic.*;

import com.shop.site.Entity.Client;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientDAO extends CommonDAO<Client, Integer> {
    public ClientDAO(){
        super(Client.class);
    }
    public void changePassword(Client obj, String oldPassword, String newPassword){
        if (Objects.equals(obj.getPassword(), oldPassword)){
            obj.setPassword(newPassword);
        }
    }

    public Client findClientByLogin(String login){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder("SELECT c FROM Client c WHERE c.login = :login");
            TypedQuery<Client> query = session.createQuery(queryString.toString(), Client.class);
            query.setParameter("login", login);
            Client res = query.getSingleResult();
            t.commit();
            return res;
        } catch (jakarta.persistence.NoResultException e) {
            t.rollback();
            return null;
        }
    }

    public Order getCart(Client client){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {

            StringBuilder queryString = new StringBuilder("SELECT o FROM Order o WHERE o.client = :client AND o.status = 0");
            TypedQuery<Order> query = session.createQuery(queryString.toString(), Order.class);
            query.setParameter("client", client);
            Order res = query.getSingleResult();
            t.commit();
            return res;
        } catch (jakarta.persistence.NoResultException e) {
            t.rollback();
            return null;
        }
    }

//    public Boolean isValidLogin(String username, String password){
//        return (password == )
//    }

}

