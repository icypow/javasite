package Service;

import DAO.ReviewDAO;
import Entity.Review;
import Entity.ReviewID;

public class ReviewSVC extends CommonSVC<Review, ReviewID, ReviewDAO> {
    public ReviewSVC(){
        super(new ReviewDAO());
    }
}
