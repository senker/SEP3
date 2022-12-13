package via.sep3.persistencetier.database.userInfo;

import via.sep3.persistencetier.database.userInfo.Address;

import javax.persistence.*;


@MappedSuperclass
public class User {
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName="id")
    private Address address;
    @Column(name="phone_number")
    private Long phoneNumber;

    @Id
    @Column(name="email")
    private String email;

    @Column(name="password",
            columnDefinition = "varchar(255)")
    private String password;

    @Column(name="role",
            columnDefinition = "varchar(255)")
    private String role;

    public User(String firstName,
                String lastName,
                Address address,
                Long phoneNumber,
                String email,
                String password,
                String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}