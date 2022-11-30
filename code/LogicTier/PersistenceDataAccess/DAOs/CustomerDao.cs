using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;
using PersistenceDataAccess.Services;

namespace PersistenceDataAccess.DAOs;

public class CustomerDao : ICustomerDao
{
    private readonly CustomerService.CustomerServiceClient _client;

    public CustomerDao(IGrpcService grpcService)
    {
        _client = new CustomerService.CustomerServiceClient(grpcService.GetChannel());
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
            var response = await _client.createCustomerAsync(
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
            throw new Exception("", e);

        }
    }

    public async Task<CustomerDto?> DeleteCustomerByEmailAsync(string email)
    {
        try
        {
            var response = await _client.deleteCustomerByEmailAsync(
                new CustomerRequest() { Email = email }
            );

            return ResponseToCustomerDto(response);
        }
        catch
        {
            return null;
        }
    }
    
    public async Task<CustomerDto?> GetCustomerByEmailAsync(string email)
    {
        try
        {
            var response = await _client.getCustomerByEmailAsync(
                new CustomerRequest { Email = email }
            );

            return ResponseToCustomerDto(response);
        }
        catch
        {
            throw new Exception("Couldn't get the email");
        }
    }
    
    public async  Task<List<CustomerDto>> GetAllCustomers()
    {
        
        try
        {
            List<CustomerDto> customerList = new List<CustomerDto>();
            AsyncServerStreamingCall<CustomerResponse> response = _client.getAllCustomers(new EmptyCustomer());
            while (await response.ResponseStream.MoveNext())
            {
                CustomerResponse current = response.ResponseStream.Current;
                customerList.Add(ResponseToCustomerDto(current));
            }

            return customerList;
        }
        catch
        {
            throw new Exception("Couldn't load all customers");
        }
    }

    public Task<CustomerDto> ValidateCustomer(string username, string password)
    {
        /*AsyncServerStreamingCall<CustomerResponse>  existingCustomers = _client.getAllCustomers(new Google.Protobuf.WellKnownTypes.Empty());
        List<CustomerDto> customerList = new List<CustomerDto>();
        while (existingCustomers.ResponseStream.MoveNext())
        {
            CustomerResponse current = existingCustomers.ResponseStream.Current;
            customerList.Add(ResponseToCustomerDto(current));
        }*/
        /*List<CustomerDto> customerList = new List<CustomerDto>();
        customerList.Add(GetAllCustomers());*/
        var customerList = GetAllCustomers();
        var existingCustomer = customerList.Result.FirstOrDefault(u => 
        u.User.Email.Equals(username, StringComparison.OrdinalIgnoreCase));

        
        if (existingCustomer == null)
        {
            throw new Exception("User not found");
        }

        /*if (!existingCustomer.Password.Equals(password))
        {
            throw new Exception("Password mismatch");
        }*/

        return Task.FromResult(existingCustomer);
    }

    public Task RegisterCustomer(CustomerDto customer)
    {
        throw new NotImplementedException();
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

        return new CustomerDto()
        {
            User = user,
            Preference = response.Preference
        };
    }

}