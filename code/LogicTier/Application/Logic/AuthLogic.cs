using Application.DaoInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using WastelessWASM;

namespace Application.Logic;

public class AuthLogic : IAuthLogic
{
    private readonly ICustomerDao customerDao;
    private readonly ISellerDao sellerDao;

    public AuthLogic(ICustomerDao customerDao, ISellerDao sellerDao)
    {
        this.customerDao = customerDao;
        this.sellerDao = sellerDao;
    }

    public Task<CustomerDto?> ValidateCustomer(String Username, String Password)
    {
        MessageQueue messageQueue = new MessageQueue();
        MessageQueueLogic.send(messageQueue);
        return customerDao.ValidateCustomer(Username, Password);
    }

    public Task<SellerDto?> ValidateSeller(String Username, String Password)
    {
        return sellerDao.ValidateSeller(Username, Password);
    }
}