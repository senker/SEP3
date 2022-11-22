using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using PersistenceDataAccess.Services;
using static PersistenceDataAccess.CustomerService;

namespace PersistenceDataAccess.DAOs;

public class CustomerDao : ICustomerDao
{
    //CustomerProtoGrpc.cs
    private readonly CustomerServiceClient  _client;
    
    public CustomerDao(IGrpcService grpcService)
    {
        _client = new CustomerServiceClient(grpcService.GetChannel());
    }
    
    public async Task<CustomerDto?> CreateCustomerAsync(CustomerCreateDto customer)
    {
        AddressModelCustomer address = new AddressModelCustomer()
        {
            City = customer.User.Address.City,
            StreetName = customer.User.Address.Streetname,
            PostCode = customer.User.Address.Postcode
        };
        
        
        CreateUserModelRequestCustomer user = new CreateUserModelRequestCustomer();
        user.FirstName = customer.User.FirstName;
        user.LastName = customer.User.LastName;
        user.Address = address;
        user.PhoneNumber = customer.User.PhoneNumber;
        user.Email = customer.User.Email;
        
        try
        {
            var response =  await _client.createCustomerAsync(
                new CreateCustomerRequest()
                {
                    User = user,
                    Preference = customer.Preference
                }
            );

            return ResponseToCustomerDto(response);
        }
        catch (Exception e)
        {
            Console.WriteLine("{0} Exception caught.", e);
            throw new Exception("",e);

        }
    }
    
    private CustomerDto ResponseToCustomerDto(CustomerResponse response)
    {
        var address = new Domain.Models.AddressModel
        {
            City = response.User.Address.City,
            Streetname = response.User.Address.StreetName,
            Postcode = response.User.Address.PostCode
        };

        UserModel user = new UserModel();
        user.FirstName = response.User.FirstName;
        user.LastName = response.User.LastName;
        user.Address = address;
        user.PhoneNumber = response.User.PhoneNumber;
        user.Email = response.User.Email;
        
        return new CustomerDto
        {
            User = user,
            Preference = response.Preference
        };
    }

    public async Task<CustomerDto?> GetCustomerByEmailAsync(string email)
    {
        try
        {
            var response = await _client.getCustomerByEmailAsync(
                new CustomerRequest{ Email = email }
            );

            return ResponseToCustomerDto(response);
        }
        catch
        {
            throw new Exception("Couldn't get the email");
        }
    }

    public async Task<CustomerDto?> DeleteCustomerByEmailAsync(string email)
    {
        try
        {
            var response = await _client.deleteCustomerByEmailAsync(
                new CustomerRequest { Email = email }
            );

            return ResponseToCustomerDto(response);
        }
        catch
        {
            return null;
        }
    }
}