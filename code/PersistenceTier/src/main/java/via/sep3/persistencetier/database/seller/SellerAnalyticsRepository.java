package via.sep3.persistencetier.database.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerAnalyticsRepository extends JpaRepository<SellerAnalytics, Integer> {

    @Query(value = "select rating from seller_analytics where seller_analytics.cvr=?1", nativeQuery = true)
    Seller findByCvr(int cvr);



    @Modifying
    @Query(value = "update seller_analytics r set r.rating = ?1 where r.seller = ?2", nativeQuery = true)
    void updateRating(double rating, Seller seller);
}
