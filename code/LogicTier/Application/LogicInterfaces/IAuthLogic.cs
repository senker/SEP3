using Domain.DTOs;

namespace Application.LogicInterfaces;

public interface IAuthLogic
{
    Task<CustomerDto?> ValidateCustomer(String Username, String Password);
    Task<SellerDto?> ValidateSeller(String Username, String Password);
}