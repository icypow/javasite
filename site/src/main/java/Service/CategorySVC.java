package Service;
import java.util.List;
import DAO.*;
import Entity.*;
public class CategorySVC extends CommonSVC<Category, CategoryDAO>{
    public CategorySVC(){
        super(new CategoryDAO());
    }
}
