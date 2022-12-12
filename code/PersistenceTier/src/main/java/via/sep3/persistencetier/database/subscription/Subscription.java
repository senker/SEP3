package via.sep3.persistencetier.database.subscription;

import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.reservation.ReservationId;
import via.sep3.persistencetier.database.seller.Seller;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="subscription")
public class Subscription{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="seller_cvr", referencedColumnName = "cvr"),
            @JoinColumn(name="seller_email", referencedColumnName = "email")
    })
    private Seller cvr;

    @ManyToOne
    @JoinColumn(name="email", referencedColumnName = "email")
    private Customer email;

    public Subscription() {
    }

    public Subscription(Seller cvr, Customer email) {
        this.cvr = cvr;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seller getSellerId() {
        return cvr;
    }

    public void setSellerId(Seller cvr) {
        this.cvr = cvr;
    }

    public Customer getCustomerId() {
        return email;
    }

    public void setCustomerId(Customer email) {
        this.email = email;
    }
}
