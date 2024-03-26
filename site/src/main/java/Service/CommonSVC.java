package Service;

import java.util.List;

import DAO.CommonDAO;

public abstract class CommonSVC<T, DAO extends CommonDAO<T>> {
    protected DAO dao;

    public CommonSVC(DAO dao){
        this.dao = dao;
    }

    public T findById(int id){
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

    public void deleteById(int id){
        dao.deleteById(id);
    }
}