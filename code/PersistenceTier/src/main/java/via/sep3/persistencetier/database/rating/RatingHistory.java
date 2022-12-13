package via.sep3.persistencetier.database.rating;

import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.seller.Seller;

import javax.persistence.*;

@Entity
@Table(name="rating_history")
public class RatingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="rating")
    private Float rating;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Seller seller;

    public RatingHistory() {
    }

    public RatingHistory(int id, Float rating, Customer customer, Seller seller) {
        this.id = id;
        this.rating = rating;
        this.customer = customer;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
