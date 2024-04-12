package com.shop.site;
import org.junit.jupiter.api.*;
import Entity.*;
import Service.*;

import java.util.AbstractSet;
import java.util.Queue;

public class ReviewTest {

    @Test
    public void testReview(){
        Product p = new Product();
        Client c = new Client();

        Review r = new Review(p, c, 5, "Very good!");
        Assertions.assertEquals(r.getProduct(), p);
        Assertions.assertEquals(r.getClient(), c);
        Assertions.assertEquals(r.getRate(), 5);
        Assertions.assertEquals(r.getReviewText(), "Very good!");

    }




}
