package com.shop.site.Entity;
import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class ReviewID implements Serializable{

        private int Client_ID;
        private int Product_ID;

        public ReviewID(int client, int product){
            this.Client_ID = client;
            this.Product_ID = product;
        }
        public ReviewID(){
        }
}
