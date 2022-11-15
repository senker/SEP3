namespace Domain.DTOs;
using Domain.Models;

public class CustomerDto
{
    public UserModel User { get; set; }
    public string? Preference { get; set; }

    public CustomerDto() {
    }

    public CustomerDto(CustomerModel customer) =>
        (User, Preference) = (
            customer.User, customer.Preference);
}

public class CustomerCreateDto
{
    public UserCreateModel User { get; set; }
    public string? Preference { get; set; }

    public CustomerCreateDto() {
    }

    public CustomerCreateDto(CustomerCreateModel customer) =>
        (User, Preference) = (
            customer.User, customer.Preference);
}