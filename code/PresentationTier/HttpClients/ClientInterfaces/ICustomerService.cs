using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICustomerService
{
    Task<CustomerModel> CreateCustomer(CustomerCreateModel dto);
}