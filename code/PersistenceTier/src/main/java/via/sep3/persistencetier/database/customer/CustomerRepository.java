package via.sep3.persistencetier.database.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.customer.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from Customer where Customer.email=?1", nativeQuery = true)
    Customer findByEmail(String email);

    @Query(value = "Delete from Customer where Customer.email=?1", nativeQuery = true)
    Customer deleteByEmail(String email);

    @Query(value = "select * from Customer c where c.firstName=?1 and c.lastName = ?2", nativeQuery = true)
    List<Customer> findByFirstNameAndLastName(String firstName, String LastName);
}
