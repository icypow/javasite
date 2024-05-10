package com.shop.site.Service;

import java.util.List;

import com.shop.site.DAO.CommonDAO;

public abstract class CommonSVC<T, PrimaryKey, DAO extends CommonDAO<T, PrimaryKey>> {
    protected DAO dao;

    public CommonSVC(DAO dao){
        this.dao = dao;
    }

    public T findById(PrimaryKey id){
        return dao.findById(id);
    }

    public List<T> findAll(){
        return dao.findAll();
    }

    public void save(T obj){
        dao.save(obj);
    }

    public void update(T obj){
        dao.update(obj);
    }

    public void delete(T obj){
        dao.delete(obj);
    }

    public void deleteById(PrimaryKey id){
        dao.deleteById(id);
    }
}