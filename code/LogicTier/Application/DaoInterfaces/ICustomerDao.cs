using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface ICustomerDao
{
    Task<CustomerDto?> CreateCustomerAsync(CustomerCreateDto customer);
    Task<CustomerDto?> GetCustomerByIdAsync(int id);
    Task<CustomerDto?> DeleteCustomerByIdAsync(int id);
}