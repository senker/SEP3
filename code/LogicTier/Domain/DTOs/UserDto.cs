namespace Domain.Models;

public class UserDto
{
    public int Id { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public AddressModel Address { get; set; }
    public int PhoneNumber { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }
    public string Role { get; set; }

    public UserDto() {
    }

    public UserDto(UserModel user) =>
        (Id, FirstName, LastName, Address, PhoneNumber, Email, Password, Role) = (
            user.Id, user.FirstName, user.LastName, user.Address, user.PhoneNumber, user.Email, user.Password, user.Role);
}