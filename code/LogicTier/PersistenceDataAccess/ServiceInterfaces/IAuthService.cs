using Domain.DTOs;

namespace PersistenceDataAccess.ServiceInterfaces;

public interface IAuthService
{
    Task<CustomerDto?> ValidateCustomer(String username, String password);
    Task<SellerDto?> ValidateSeller(String username, String password);
}