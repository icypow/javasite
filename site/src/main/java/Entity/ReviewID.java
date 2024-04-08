package Entity;
import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class ReviewID implements Serializable{

        private int client_id;
        private int service_id;

        public ReviewID(int client, int service){
            this.client_id = client;
            this.service_id = service;
        }
        public ReviewID(){
        }
}
