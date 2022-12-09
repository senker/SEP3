package via.sep3.persistencetier.database.reservation;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.seller.Seller;

import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private FoodPack foodPackId;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Customer customerId;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Seller cvr;


    public Reservation(String status, FoodPack foodPackId, Customer customerId, Seller cvr) {
        this.status = status;
        this.foodPackId = foodPackId;
        this.customerId = customerId;
        this.cvr = cvr;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FoodPack getFoodPackId() {
        return foodPackId;
    }


    public void setFoodPackId(FoodPack foodPackId) {
        this.foodPackId = foodPackId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Seller getCvr() {
        return cvr;
    }

    public void setCvr(Seller cvr) {
        this.cvr = cvr;
    }
}
