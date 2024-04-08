package Entity;
import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.io.Serializable;
@Embeddable
public class ProductCategoryID implements Serializable{
    private int product_id;
    private int category_id;

    public ProductCategoryID(){};

    public ProductCategoryID(int product, int category){
        this.category_id = category;
        this.product_id = product;
    }


}
