package Entity;
import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.io.Serializable;
@Embeddable
public class ProductCategoryID implements Serializable{
    private int Product_ID;
    private int Category_ID;

    public ProductCategoryID(){};

    public ProductCategoryID(int product, int category){
        this.Category_ID = category;
        this.Product_ID = product;
    }


}
