package via.sep3.persistencetier.database.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.seller.Seller;

import java.util.List;


//for seller example use findById(123456789)
//or findById(987654321)

//count() - returns the number of entities available
//delete(T entity)
//findAll()
//findById(ID id)
//save

public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = "select * from Seller where Seller.cvr=?1", nativeQuery = true)
    Seller findByCvr(Long cvr);

    @Query(value = "Delete from Seller where Seller.cvr=?1", nativeQuery = true)
    Seller deleteByCvr(Long cvr);
}
