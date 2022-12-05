package via.sep3.persistencetier.database.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface ImageRepository extends JpaRepository<Image, Integer> {
   @Modifying
    void deleteBySeller(Seller seller);
}
