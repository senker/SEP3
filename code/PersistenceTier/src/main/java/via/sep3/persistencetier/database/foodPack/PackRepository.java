package via.sep3.persistencetier.database.foodPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PackRepository extends JpaRepository<FoodPack, Long> {

    @Query(value = "select * from FoodPack where FoodPack.id=?1", nativeQuery = true)
    FoodPack findById(int id);

    @Query(value = "select * from FoodPack where FoodPack.id=?1", nativeQuery = true)
    FoodPack deleteById(int id);
}
