package DAO;

import Entity.*;
import BuisnesLogic.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
}

