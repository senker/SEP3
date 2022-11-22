using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface ICustomerDao
{
    Task<CustomerDto?> CreateCustomerAsync(CustomerCreateDto customer);
    Task<CustomerDto?> GetCustomerByEmailAsync(string email);
    Task<CustomerDto?> DeleteCustomerByEmailAsync(string email);
}