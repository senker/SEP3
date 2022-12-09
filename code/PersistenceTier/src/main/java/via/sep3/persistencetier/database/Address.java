package via.sep3.persistencetier.database;

import javax.persistence.*;


/**
 EXAMPLE:
 id: 1,
 city: Horsens,
 postcode: 8700,
 street: Borgergade 5
 */
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String streetName;
    @Column(name="postcode")
    private Integer postcode;

    public Address(String city, String streetName, Integer postcode) {
        this.city = city;
        this.streetName = streetName;
        this.postcode = postcode;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }
}