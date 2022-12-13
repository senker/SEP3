package via.sep3.persistencetier.database.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.seller.Seller;

import java.util.List;

public interface RatingHistoryRepository extends JpaRepository<RatingHistory, Integer> {

    @Query(value = "select rating from rating_history where rating_history.cvr=?1", nativeQuery = true)
    List<Float> getAllRatingsBySeller(int cvr);
}
