namespace Domain.DTOs;
using Domain.Models;

public class CustomerDto
{
    public UserModel User { get; set; }
    public List<string> Preferences { get; set; }

    public CustomerDto() {
    }

    public CustomerDto(CustomerModel customer) =>
        (User, Preferences) = (
            customer.User, customer.Preferences);
}

public class CustomerCreateDto
{
    public UserCreateModel User { get; set; }
    public List<string> Preferences { get; set; }

    public CustomerCreateDto() {
    }

    public CustomerCreateDto(CustomerCreateModel customer) =>
        (User, Preferences) = (
            customer.User, customer.Preferences);
}