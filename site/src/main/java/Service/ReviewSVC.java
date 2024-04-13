package Service;

import DAO.ReviewDAO;
import Entity.Client;
import Entity.Product;
import Entity.Review;
import Entity.ReviewID;

import java.util.List;

public class ReviewSVC extends CommonSVC<Review, ReviewID, ReviewDAO> {
    public ReviewSVC(){
        super(new ReviewDAO());
    }


    public List<Review> getProductReviews(Product obj) { return dao.getProductReviews(obj); }


    public void leaveReview(Client clientObj, Product productObj, String text, int rate) {dao.leaveReview(clientObj, productObj, text, rate);}
}
