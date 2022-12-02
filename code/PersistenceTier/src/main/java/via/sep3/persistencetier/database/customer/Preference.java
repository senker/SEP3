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
    @JoinColumn(name="customer_id")
    private Customer customer;

}
