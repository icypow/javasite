package Service;
import java.util.List;
import DAO.*;
import Entity.*;

public class ClientSVC extends CommonSVC<Client, ClientDAO> {
    public ClientSVC(){
        super(new ClientDAO());
    }


    public void changePassword(Client obj, String oldPassword, String newPassword){
        dao.changePassword(obj, oldPassword, newPassword);
    }



}

