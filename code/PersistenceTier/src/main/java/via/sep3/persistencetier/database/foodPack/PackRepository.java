package via.sep3.persistencetier.database.foodPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.seller.Seller;

import java.util.stream.Stream;


public interface PackRepository extends JpaRepository<FoodPack, Integer> {


    @Query(value="select * from food_pack p where p.title like CONCAT(CONCAT('%', ?1), '%') and p.is_prepared=?2 and p.type=?3 and p.price<=?4 and p.seller_cvr=?5", nativeQuery = true)
    Stream<FoodPack> searchPacks(String title, boolean isPrepared, String type, Double price, Long cvr);


    @Query(value="select * from food_pack p where p.title like CONCAT(CONCAT('%', ?1), '%') and p.is_prepared=?2 and p.type=?3 and p.seller_cvr=?4", nativeQuery = true)
    Stream<FoodPack> searchPacks(String title, boolean isPrepared, String type, Long cvr);


    @Query(value = "select * from food_pack where food_pack.id=?1", nativeQuery = true)
    FoodPack findById(int id);


    @Modifying
    void deleteBySeller(Seller seller);

    @Query(value="select * from food_pack where food_pack.seller_cvr=?1", nativeQuery = true)
    Stream<FoodPack> findBySeller(int cvr);


    @Query(value="select * from food_pack", nativeQuery = true)
    Stream<FoodPack> findAllStream();
}
