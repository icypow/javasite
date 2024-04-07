package Service;

import DAO.ReviewDAO;
import Entity.Review;

public class ReviewSVC extends CommonSVC<Review, ReviewDAO> {
    public ReviewSVC(){
        super(new ReviewDAO());
    }
}
