using Application.Logic;
using Domain.DTOs;
using PersistenceDataAccess.ServiceInterfaces;
using WastelessWASM;

namespace PersistenceDataAccess.Services;

public class AuthLogic : IAuthLogic
{
    private readonly ICustomerService _customerService;
    private readonly ISellerService _sellerService;

    public AuthLogic(ICustomerService customerService, ISellerService sellerService)
    {
        _customerService = customerService;
        _sellerService = sellerService;
    }

    public Task<CustomerDto?> ValidateCustomer(String Username, String Password)
    {
        MessageQueue messageQueue = new MessageQueue();
        MessageQueueLogic.send(messageQueue);
        return _customerService.ValidateCustomer(Username, Password);
    }

    public Task<SellerDto?> ValidateSeller(String Username, String Password)
    {
        return _sellerService.ValidateSeller(Username, Password);
    }
}