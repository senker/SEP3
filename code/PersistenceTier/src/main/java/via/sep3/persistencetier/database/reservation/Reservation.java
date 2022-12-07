package via.sep3.persistencetier.database.reservation;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private FoodPack foodPackId;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Customer customerId;

    @Column(name = "startPickupTime")
    private Calendar startPickupTime;

    @Column(name = "endPickupTime")
    private Calendar endPickupTime;

    public Reservation(Long id, String status, FoodPack foodPackId, Customer customerId, Calendar startPickupTime, Calendar endPickupTime) {
        this.id = id;
        this.status = status;
        this.foodPackId = foodPackId;
        this.customerId = customerId;
        this.startPickupTime = startPickupTime;
        this.endPickupTime = endPickupTime;
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

    public Calendar getStartPickupTime() {
        return startPickupTime;
    }

    public void setStartPickupTime(Calendar startPickupTime) {
        this.startPickupTime = startPickupTime;
    }

    public Calendar getEndPickupTime() {
        return endPickupTime;
    }

    public void setEndPickupTime(Calendar endPickupTime) {
        this.endPickupTime = endPickupTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
