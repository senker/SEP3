package via.sep3.persistencetier.database.customer;

import javax.persistence.*;

@Entity
@Table (name = "preference")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "preference")
    private String preference;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Customer customer;



    public Preference() {
    }

    public Preference(String preference, Customer customer) {
        this.preference = preference;
        this.customer = customer;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
