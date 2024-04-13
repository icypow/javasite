package Service;
import java.util.List;
import DAO.*;
import Entity.*;
public class CategorySVC extends CommonSVC<Category, Integer, CategoryDAO>{
    public CategorySVC(){
        super(new CategoryDAO());
    }
}
