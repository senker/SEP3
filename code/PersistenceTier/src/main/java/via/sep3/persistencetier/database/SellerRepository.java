package via.sep3.persistencetier.database;

import org.springframework.data.jpa.repository.JpaRepository;



//for seller example use findById(123456789)
//or findById(987654321)

//count() - returns the number of entities available
//delete(T entity)
//findAll()
//findById(ID id)
//save

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
