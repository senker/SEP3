package via.sep3.persistencetier.database.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.seller.Seller;

import java.util.stream.Stream;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {



    @Query(value="SELECT * FROM reservation WHERE reservation.id=?1", nativeQuery = true)
    Reservation findById(int id);

    @Query(value="SELECT * FROM reservation WHERE reservation.food_pack_id=?1", nativeQuery = true)
    Stream<Reservation> findByFoodPack(FoodPack foodPack);

    @Query(value="SELECT * FROM reservation WHERE reservation.customer_id=?1", nativeQuery = true)
    Stream<Reservation> findByCustomerEmail(String customer);

    @Query(value="DELETE * FROM reservation WHERE reservation.id=?1", nativeQuery = true)
    void deleteById(int id);
}
