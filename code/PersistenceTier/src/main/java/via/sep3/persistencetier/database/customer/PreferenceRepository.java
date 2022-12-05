package via.sep3.persistencetier.database.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
    /*
    @Query(value = "select * from preference where preference.customer_email=?1", nativeQuery = true)
    Stream<Preference> findByEmail(String email);


     */
    @Modifying
    @Query(value="delete from preference where preference.customer_email=?1", nativeQuery = true)
    void deleteByCustomer(Customer customer);

    @Query(value="delete from preference where preference.customer.email=?1", nativeQuery = true)
    void deleteByEmail(String email);


/*
    @Query("delete from Preference p where p.customer.email in(:list)")
    void deleteFromList(List<String> list);

 */
}
