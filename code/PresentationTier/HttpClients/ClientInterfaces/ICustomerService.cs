using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICustomerService
{
    Task<CustomerModel> CreateCustomer(CustomerCreateDto dto);
}