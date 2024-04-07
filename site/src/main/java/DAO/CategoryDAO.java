package DAO;

import Entity.*;
import BuisnesLogic.*;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAO extends CommonDAO<Category> {
    public CategoryDAO(){
        super(Category.class);
    }

}
