using Application.ServiceInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using WastelessWASM;

namespace Application.Logic;

public class AuthLogic : IAuthLogic
{
    private readonly ICustomerService _customerService;
    private readonly ISellerService _sellerService;

    public AuthLogic(ICustomerService customerService, ISellerService sellerService)
    {
        this._customerService = customerService;
        this._sellerService = sellerService;
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