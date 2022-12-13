package via.sep3.persistencetier.database.seller;

import via.sep3.persistencetier.database.seller.Seller;

import javax.persistence.*;

@Table(name="rating_analytics")
public class SellerAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Seller seller;

    public SellerAnalytics() {
    }

    public SellerAnalytics(int id, Seller seller) {
        this.id = id;
        this.seller = seller;
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
}
