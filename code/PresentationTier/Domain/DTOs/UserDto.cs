namespace Domain.Models;

public class UserDto
{
    public string? FirstName { get; set; }
    public string? LastName { get; set; }
    public AddressModel Address { get; set; }
    public int? PhoneNumber { get; set; }
    public string? Email { get; set; }
    public string Password { get; set; }
    
    public UserDto() {
    }

    public UserDto(UserModel user) =>
        ( FirstName, LastName, Address, PhoneNumber, Email, Password) = (
            user.FirstName, user.LastName, user.Address, user.PhoneNumber, user.Email, user.Password);
    
    public UserDto(UserCreateModel user) =>
        (FirstName, LastName, Address, PhoneNumber, Email, Password) = (
            user.FirstName, user.LastName, user.Address, user.PhoneNumber, user.Email, user.Password);
}