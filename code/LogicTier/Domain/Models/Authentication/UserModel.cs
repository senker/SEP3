namespace Domain.Models;

public class User
{
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public AddressModel Address { get; set; }
    public int PhoneNumber { get; set; }
    public string Email { get; set; }
}

public class AddressModel
{
    public string City { get; set; }
    public string Streetname { get; set; }
    public int Postcode { get; set; }
}

