namespace Domain.Models;

public class UserModel
{
    public int Id { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public AddressModel Address { get; set; }
    public int PhoneNumber { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }
    public string Role { get; set; }
    
}

public class AddressModel
{

    public string City { get; set; }
    public string Streetname { get; set; }
    public int Postcode { get; set; }

    public AddressModel(string city, string streetname, int postcode)
    {
        City = city;
        Streetname = streetname;
        Postcode = postcode;
    }
}

public class UserCreateModel
{
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public AddressModel Address { get; set; }
    public int PhoneNumber { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }
    public string Role { get; set; }
    
    public UserCreateModel(string firstName, string lastName, AddressModel address, int phoneNumber, string email, string password, string role)
    {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
        Password = password;
        Role = role;
    }
}
