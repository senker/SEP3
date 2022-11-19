package via.sep3.persistencetier.database.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.customer.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    @Query(value = "select * from Customer c where c.firstName=firstName and c.lastName = lastName", nativeQuery = true)
    List<Customer> findByFirstNameAndLastName(String firstName, String LastName);
}
