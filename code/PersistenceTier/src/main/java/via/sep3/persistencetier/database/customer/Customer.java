package via.sep3.persistencetier.database.customer;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

@Entity(name="Customer")
@Table(name="customer")
public class Customer extends User {

    //@Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    //private int id;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preference> preferences;


    public Customer(String firstName, String lastName, Address address, Long phoneNumber, String email, String password, List<Preference> preferences) {
        super(firstName, lastName, address, phoneNumber, password, email);

        this.preferences = preferences;
    }

    public Customer(){
        super("","",null,0L,"", "");
    }


     public List<Preference> getPreference() {
        return preferences;}

    public void setPreference(List<Preference> preferences) {
        this.preferences = preferences;
    }


}
