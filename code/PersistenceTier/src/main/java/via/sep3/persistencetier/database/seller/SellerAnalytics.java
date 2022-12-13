package via.sep3.persistencetier.database.seller;

import via.sep3.persistencetier.database.seller.Seller;

import javax.persistence.*;

@Table(name="seller_analytics")
public class SellerAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Seller seller;

    @Column(name="rating")
    private float rating;

    public SellerAnalytics() {
    }

    public SellerAnalytics( Seller seller, float rating) {
        this.seller = seller;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
