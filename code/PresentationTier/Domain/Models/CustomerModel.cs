namespace Domain.Models;

public class CustomerModel
{
    public UserModel User { get; set; }
    public List<string> Preferences { get; set; }
}

public class CustomerCreateModel
{
    public UserCreateModel User { get; set; }
    public List<string> Preferences { get; set; }

    public CustomerCreateModel(UserCreateModel userModel, List<string> preferences)
    {
        User = userModel;
        Preferences = preferences;
    }
}