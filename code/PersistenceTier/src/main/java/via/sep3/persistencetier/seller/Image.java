package via.sep3.persistencetier.seller;

import via.sep3.persistencetier.database.customer.Customer;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(columnDefinition="TEXT",name="partial_url")
    private String partialImage;

    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;

    public Image(){

    }

    public Image(String partialImage) {
        this.partialImage = partialImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartialImage() {
        return partialImage;
    }

    public void setPartialImage(String partialImage) {
        this.partialImage = partialImage;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
