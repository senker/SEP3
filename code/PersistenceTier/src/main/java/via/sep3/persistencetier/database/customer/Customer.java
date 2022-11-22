package via.sep3.persistencetier.database.customer;

import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Customer")
@Table(name="customer")
public class Customer extends User {

    //@Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    //private int id;

    private String preference;

    public Customer(String firstName, String lastName, Address address, Long phoneNumber, String email, String preference) {
        super(firstName, lastName, address, phoneNumber, email);

        this.preference = preference;
    }

    public Customer(){
        super("","",null,0L,"");
    }


     public String getPreference() {
        return preference;}

    public void setPreference(String preference) {
        this.preference = preference;
    }


}
