package via.sep3.persistencetier.database.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.seller.Seller;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query(value="SELECT * FROM reservation WHERE reservation.cvr=?1", nativeQuery = true)
    Seller findBySellerCvr(Seller seller);

    @Query(value="SELECT * FROM reservation WHERE reservation.id=?1", nativeQuery = true)
    Reservation findById(int id);

    @Query(value="DELETE * FROM reservation WHERE reservation.id=?1", nativeQuery = true)
    void deleteById(int id);
}
