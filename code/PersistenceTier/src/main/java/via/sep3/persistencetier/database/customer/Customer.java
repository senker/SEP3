package via.sep3.persistencetier.database.customer;

import via.sep3.persistencetier.database.userInfo.Address;
import via.sep3.persistencetier.database.userInfo.User;

import javax.persistence.*;
import java.util.List;

@Entity(name="Customer")
@Table(name="customer")
public class Customer extends User {

    //@Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    //private int id;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preference> preferences;


    public Customer(String firstName, String lastName, Address address, Long phoneNumber, String email, String password, String role, List<Preference> preferences) {
        super(firstName, lastName, address, phoneNumber, password, email, role);

        this.preferences = preferences;
    }

    public Customer(){
        super("","",null,0L,"", "", "");
    }


     public List<Preference> getPreference() {
        return preferences;}

    public void setPreference(List<Preference> preferences) {
        this.preferences = preferences;
    }


}
