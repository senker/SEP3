using Application.Logic;
using Domain.DTOs;
using PersistenceDataAccess.ServiceInterfaces;
using WastelessWASM;

namespace PersistenceDataAccess.Services;
// references https://troelsmortensen.github.io/CodeLabs/Tutorials/BlazorWasmJwtAuth/Page.html
public class AuthService : IAuthService
{
    private readonly ICustomerService _customerService;
    private readonly ISellerService _sellerService;

    public AuthService(ICustomerService customerService, ISellerService sellerService)
    {
        _customerService = customerService;
        _sellerService = sellerService;
    }

    public Task<CustomerDto?> ValidateCustomer(String username, String password)
    {
        MessageQueue messageQueue = new MessageQueue();
        MessageQueueLogic.send(messageQueue);
        return _customerService.ValidateCustomer(username, password);
    }

    public Task<SellerDto?> ValidateSeller(String username, String password)
    {
        return _sellerService.ValidateSeller(username, password);
    }
}