package Service;
import java.util.List;
import DAO.*;
import Entity.*;

public class ClientSVC extends CommonSVC<Client, ClientDAO> {
    public ClientSVC(){
        super(new ClientDAO());
    }
}
