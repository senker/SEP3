package via.sep3.persistencetier.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;


//for seller example use findById(123456789)
//or findById(987654321)

//count() - returns the number of entities available
//delete(T entity)
//findAll()
//findById(ID id)
//save

public interface SellerRepository extends JpaRepository<Seller, String> {

    @Query(value = "select * from Seller where Seller.cvr=?1", nativeQuery = true)
    Seller findByCvr(Long cvr);

    @Query(value = "Delete from Seller where Seller.cvr=?1", nativeQuery = true)
    Seller deleteByCvr(Long cvr);

    @Query(value="select * from Seller", nativeQuery = true)
    Stream<Seller> findAllStream();
}
