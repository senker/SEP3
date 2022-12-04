package via.sep3.persistencetier.database.foodPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.protobuf.foodPackRequest;


public interface PackRepository extends JpaRepository<FoodPack, Long> {

    @Query(value = "select * from FoodPack where FoodPack.id=?1", nativeQuery = true)
    FoodPack findById(foodPackRequest id);

    @Query(value = "select * from FoodPack where FoodPack.id=?1", nativeQuery = true)
    FoodPack deleteById(foodPackRequest id);
}
