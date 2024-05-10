package com.shop.site.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Review")
public class Review {

    @EmbeddedId
    private ReviewID id;

    @ManyToOne
    @JoinColumn(name = "Product_ID", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Client_ID", insertable = false, updatable = false)
    private Client client;

    @Column(name = "Rate")
    private int rate;

    @Column(name = "Review_Text")
    private String reviewText;

    public Review(Product product, Client client, int rate, String reviewText) {
        this.rate = rate;
        this.id = new ReviewID(client.getClientId(), product.getProductId());
        this.client = client;
        this.product = product;
        this.reviewText = reviewText;
    }

    public Review() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public ReviewID getId() {
        return id;
    }

    public void setId(ReviewID id) {
        this.id = id;
    }
}
