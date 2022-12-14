using Domain.DTOs;

namespace PersistenceDataAccess.ServiceInterfaces;

public interface IAuthLogic
{
    Task<CustomerDto?> ValidateCustomer(String Username, String Password);
    Task<SellerDto?> ValidateSeller(String Username, String Password);
}