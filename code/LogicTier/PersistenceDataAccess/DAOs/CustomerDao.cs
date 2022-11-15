using Application.DaoInterfaces;
using Domain.DTOs;

namespace PersistenceDataAccess.DAOs;

public class CustomerDao : ICustomerDao
{
    //private readonly CustomerService  _client;
    public Task<CustomerDto?> CreateCustomerAsync(CustomerCreateDto customer)
    {
        throw new NotImplementedException();
    }

    public Task<CustomerDto?> GetCustomerByIdAsync(int id)
    {
        throw new NotImplementedException();
    }

    public Task<CustomerDto?> DeleteCustomerByIdAsync(int id)
    {
        throw new NotImplementedException();
    }
}