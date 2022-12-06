package via.sep3.persistencetier.database.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query(value="select * from Seller where Seller.address.postcode=?1", nativeQuery = true)
    Seller findByPostCode(int postcode);

    @Query(value="select cvr from Seller where Seller.address_id=?1", nativeQuery = true)
    Long findByAddressId(Long id);

    @Modifying
    @Query(value = "Delete from Seller where Seller.cvr=?1", nativeQuery = true)
    void deleteByCvr(Long cvr);

    @Query(value="select * from Seller", nativeQuery = true)
    Stream<Seller> findAllStream();
}
