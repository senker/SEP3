package via.sep3.persistencetier.database.userInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.userInfo.Address;

import java.util.stream.Stream;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select * from address where postcode=?1", nativeQuery = true)
    Stream<Address> findByPostCode(int postcode);
}
