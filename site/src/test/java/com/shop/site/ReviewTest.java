package com.shop.site;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

import java.util.AbstractSet;
import java.util.Queue;

public class ReviewTest {
    static ReviewSVC rsvc = new ReviewSVC();
    static ClientSVC csvc = new ClientSVC();
    static ProductSVC psvc = new ProductSVC();
    @Test
    public void testReview(){
        Product p = new Product();
        Client c = new Client();
        csvc.save(c);
        psvc.save(p);
        p = psvc.findAll().get(0);
        c = csvc.findAll().get(0);
        Review r = new Review(p, c, 5, "Very good!");
        rsvc.save(r);
        Assertions.assertEquals(r.getProduct(), p);
        Assertions.assertEquals(r.getClient(), c);
        Assertions.assertEquals(r.getRate(), 5);
        Assertions.assertEquals(r.getReviewText(), "Very good!");
        Assertions.assertEquals(rsvc.getProductReviews(p).get(0).getReviewText(), "Very good!");
        rsvc.delete(r);
        rsvc.leaveReview(c, p, "Nice product!", 5);
        System.out.println(rsvc.getProductReviews(p));
//        Assertions.assertEquals(rsvc.getProductReviews(p).get(0).getReviewText(), "Nice product!");
        rsvc.delete(rsvc.getProductReviews(p).get(0));
        psvc.delete(p);
        csvc.delete(c);


    }




}
