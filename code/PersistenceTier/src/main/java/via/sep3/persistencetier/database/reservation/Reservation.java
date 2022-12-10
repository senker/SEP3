package via.sep3.persistencetier.database.reservation;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerId;

import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name="reservation")
@IdClass(ReservationId.class)
public class Reservation {
    @Column(name = "status")
    private String status;

    @Id
    @ManyToOne
   // @PrimaryKeyJoinColumn
    @JoinColumn(name="food_pack_id")
    private FoodPack foodPackId;

    @Id
    @ManyToOne
   // @PrimaryKeyJoinColumn
    @JoinColumn(name="customer_id")
    private Customer customerId;

   // @ManyToOne
   // @PrimaryKeyJoinColumn
   // private Seller cvr;


    public Reservation(String status, FoodPack foodPackId, Customer customerId) {
        this.status = status;
        this.foodPackId = foodPackId;
        this.customerId = customerId;
    }

    public Reservation() {
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

 /*   public Seller getCvr() {
        return cvr;
    }

    public void setCvr(Seller cvr) {
        this.cvr = cvr;
    }
  */
}
