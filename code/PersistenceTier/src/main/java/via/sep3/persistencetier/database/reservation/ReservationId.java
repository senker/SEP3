package via.sep3.persistencetier.database.reservation;

import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.foodPack.FoodPack;

import java.io.Serializable;

public class ReservationId implements Serializable {

    private Integer foodPackId;
    private String customerId;

    public ReservationId() {
    }

    public ReservationId(Integer foodPackId, String customerId) {
        this.foodPackId = foodPackId;
        this.customerId = customerId;
    }

    public Integer getFoodPack() {
        return foodPackId;
    }

    public void setFoodPack(Integer foodPack) {
        this.foodPackId = foodPack;
    }

    public String getCustomer() {
        return customerId;
    }

    public void setCustomer(String customer) {
        this.customerId = customer;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
