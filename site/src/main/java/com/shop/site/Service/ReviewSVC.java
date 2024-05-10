package com.shop.site.Service;

import com.shop.site.DAO.ReviewDAO;
import com.shop.site.Entity.Client;
import com.shop.site.Entity.Product;
import com.shop.site.Entity.Review;
import com.shop.site.Entity.ReviewID;

import java.util.List;

public class ReviewSVC extends CommonSVC<Review, ReviewID, ReviewDAO> {
    public ReviewSVC(){
        super(new ReviewDAO());
    }


    public List<Review> getProductReviews(Product obj) { return dao.getProductReviews(obj); }


    public void leaveReview(Client clientObj, Product productObj, String text, int rate) {dao.leaveReview(clientObj, productObj, text, rate);}
}
