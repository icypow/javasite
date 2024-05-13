package com.shop.site.Entity;

public class ReviewWithAuthor {
     private Review review;
     private Client client;

     public ReviewWithAuthor(Review review, Client client){
         this.review = review;
         this.client = client;
     }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
