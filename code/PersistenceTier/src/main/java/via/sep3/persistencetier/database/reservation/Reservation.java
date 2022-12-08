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

    @Column(name = "startPickupTime")
    private String startPickupTime;

    @Column(name = "endPickupTime")
    private String endPickupTime;


    public Reservation(String status, FoodPack foodPackId, Customer customerId, String startPickupTime, String endPickupTime, Seller cvr) {
        this.status = status;
        this.foodPackId = foodPackId;
        this.customerId = customerId;
        this.startPickupTime = startPickupTime;
        this.endPickupTime = endPickupTime;
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

    public String getStartPickupTime() {
        return startPickupTime;
    }

    public void setStartPickupTime(String startPickupTime) {
        this.startPickupTime = startPickupTime;
    }

    public String getEndPickupTime() {
        return endPickupTime;
    }

    public void setEndPickupTime(String endPickupTime) {
        this.endPickupTime = endPickupTime;
    }

    public Seller getCvr() {
        return cvr;
    }

    public void setCvr(Seller cvr) {
        this.cvr = cvr;
    }
}
