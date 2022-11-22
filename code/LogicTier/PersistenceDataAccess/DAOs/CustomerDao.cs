using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using PersistenceDataAccess.Services;

namespace PersistenceDataAccess.DAOs;

public class CustomerDao : ICustomerDao
{
    private readonly CustomerService.CustomerServiceClient _client;
    
    public CustomerDao(IGrpcService grpcService)
    {
        _client = new CustomerService.CustomerServiceClient(grpcService.GetChannel());
    }
    
    //private readonly CustomerService  _client;
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


    public async Task<CustomerDto?> GetCustomerByIdAsync(int id)
    {
        try
        {
            var response = await _client.getCustomerByIdAsync(
                new CustomerRequest { Id = id }
            );

            return ResponseToCustomerDto(response);
        }
        catch
        {
            throw new Exception("Couldn't get the id");
        }
    }

    public async Task<CustomerDto?> DeleteCustomerByIdAsync(int id)
    {
        try
        {
            var response = await _client.deleteCustomerByIdAsync(
                new CustomerRequest() { Id = id }
            );

            return ResponseToCustomerDto(response);
        }
        catch
        {
            return null;
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
        user.Id = response.User.Id;
        user.FirstName = response.User.FirstName;
        user.LastName = response.User.LastName;
        user.Address = address;
        user.PhoneNumber = response.User.PhoneNumber;
        user.Email = response.User.Email;
        
        return new CustomerDto()
        {
            User = user,
            Preference = response.Preference
        };
    }
    
}