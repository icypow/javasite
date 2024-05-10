package com.shop.site.Service;
import com.shop.site.DAO.*;
import com.shop.site.Entity.*;
import com.shop.site.DAO.ClientDAO;
import com.shop.site.Entity.Client;

public class ClientSVC extends CommonSVC<Client, Integer, ClientDAO> {
    public ClientSVC(){
        super(new ClientDAO());
    }


    public void changePassword(Client obj, String oldPassword, String newPassword){
        dao.changePassword(obj, oldPassword, newPassword);
    }

    public Client findClientByLogin(String login){
        return dao.findClientByLogin(login);
    }




}

