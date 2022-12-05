package via.sep3.persistencetier.database.foodPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;


public interface PackRepository extends JpaRepository<FoodPack, Integer> {


    @Query(value="select * from food_pack p where p.title like CONCAT(CONCAT('%', ?1), '%') and p.is_prepared=?2 and p.type=?3 and p.price<=?4 and p.seller.address.postcode=?5", nativeQuery = true)
    Stream<FoodPack> searchPacks(String title, boolean isPrepared, String type, Double price, Integer postCode);


    @Query(value="select * from food_pack p where p.title like CONCAT(CONCAT('%', ?1), '%') and p.is_prepared=?2 and p.type=?3 and p.seller.address.postcode=?4", nativeQuery = true)
    Stream<FoodPack> searchPacks(String title, boolean isPrepared, String type, Integer postCode);


    @Query(value = "select * from food_pack where FoodPack.id=?1", nativeQuery = true)
    FoodPack findById(int id);

    @Query(value = "select * from food_pack where FoodPack.id=?1", nativeQuery = true)
    FoodPack deleteById(int id);

    @Query(value="select * from food_pack", nativeQuery = true)
    Stream<FoodPack> findAllStream();
}
