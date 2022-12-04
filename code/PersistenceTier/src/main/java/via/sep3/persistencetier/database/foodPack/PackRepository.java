package via.sep3.persistencetier.database.foodPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;


public interface PackRepository extends JpaRepository<FoodPack, Integer> {

    @Query(value = "select * from FoodPack where FoodPack.id=?1", nativeQuery = true)
    FoodPack findById(int id);

    @Query(value = "select * from FoodPack where FoodPack.id=?1", nativeQuery = true)
    FoodPack deleteById(int id);

    @Query(value="select * from FoodPack", nativeQuery = true)
    Stream<FoodPack> findAllStream();
}
