using Domain.DTOs;

namespace PersistenceDataAccess.ServiceInterfaces;

public interface ICustomerService
{
    Task<CustomerDto?> CreateCustomerAsync(CustomerCreateDto customer);
    Task<CustomerDto?> GetCustomerByEmailAsync(string email);
    Task<CustomerDto?> DeleteCustomerByEmailAsync(string email);
    Task<List<CustomerDto>> GetAllCustomers();
    Task<CustomerDto?> ValidateCustomer(string username, string password);
}