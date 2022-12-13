package via.sep3.persistencetier.database.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "select * from Customer where Customer.email=?1", nativeQuery = true)
    Customer findByEmail(String email);

    @Modifying
    @Query(value = "delete from customer where customer.email=?1", nativeQuery = true)
    void deleteByEmail(String email);

    @Query(value="select * from Customer", nativeQuery = true)
    Stream<Customer> findAllStream();
}
