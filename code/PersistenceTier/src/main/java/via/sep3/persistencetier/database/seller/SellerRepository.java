package via.sep3.persistencetier.database.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep3.persistencetier.database.seller.Seller;


//for seller example use findById(123456789)
//or findById(987654321)

//count() - returns the number of entities available
//delete(T entity)
//findAll()
//findById(ID id)
//save

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
