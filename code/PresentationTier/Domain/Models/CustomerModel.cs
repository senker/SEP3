namespace Domain.Models;

public class CustomerModel
{
    public UserModel User { get; set; }
    public string? Preference { get; set; }
}

public class CustomerCreateModel
{
    public UserCreateModel User { get; set; }
    public string? Preference { get; set; }

    public CustomerCreateModel(UserCreateModel user, string? preference)
    {
        User = user;
        Preference = preference;
    }
}