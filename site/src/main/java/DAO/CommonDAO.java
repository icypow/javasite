package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import BuisnesLogic.HibernateUtil;

public abstract class CommonDAO<T> {
    private final Class<T> entityClass;

    public CommonDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public T findById(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        // session.flush();
        T b = session.get(entityClass, id);
        t.commit();
        return b;
    }

    public List<T> findAll(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.flush();
        List<T> b = session.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
        t.commit();
        return b;
    }

    public void save(T obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.persist(obj);
        session.flush();
        t.commit();
        session.close();
    }

    public void saveCollection(List<T> objs){
        HibernateUtil.getSessionFactory()
                .inTransaction(session -> {
                    for (T obj : objs) {
                        session.persist(obj);
                    }
                    session.flush();
                });
    }

    public void update(T obj){
        HibernateUtil.getSessionFactory()
                .inTransaction(session -> {
                    session.merge(obj);
                    session.flush();
                });
    }

    public void delete(T obj){
        HibernateUtil.getSessionFactory()
                .inTransaction(session -> {
                    session.remove(obj);
                    session.flush();
                });
    }

    public void deleteById(int id){
        HibernateUtil.getSessionFactory()
                .inTransaction(session -> {
                    session.remove(findById(id));
                    session.flush();
                });
    }
}