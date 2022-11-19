package via.sep3.persistencetier.database.customer;

import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer extends User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<Preference> preferences;

    public Customer(String firstName, String lastName, Address address, Long phoneNumber, String email, List<String> preferences) {
        super(firstName, lastName, address, phoneNumber, email);

        this.preferences = convertToListOfPreferences(preferences);
    }

    public Customer(){
        super("","",null,0L,"");
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public List<Preference> getPreferences() {
        return preferences;}

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    private List<Preference> convertToListOfPreferences(List<String> preferences)
    {
        ArrayList<Preference> tmpList = new ArrayList<>();
        for(int i=0; i< preferences.size(); i++){
            this.preferences.add(new Preference(preferences.get(i)));
        }
        return tmpList;
    }
}
