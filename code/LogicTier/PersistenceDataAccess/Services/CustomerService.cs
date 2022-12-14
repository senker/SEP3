using System.ComponentModel.DataAnnotations;
using Application.ServiceInterfaces;
using Domain.DTOs;
using Domain.Models;
using Google.Protobuf.Collections;
using Grpc.Core;
using PersistenceDataAccess.Services;

namespace PersistenceDataAccess.Services;

public class CustomerService : ICustomerService
{
    private readonly PersistenceDataAccess.CustomerService.CustomerServiceClient _client;

    public CustomerService(IGrpcService grpcService)
    {
        _client = new PersistenceDataAccess.CustomerService.CustomerServiceClient(grpcService.GetChannel());
    }

    public async Task<CustomerDto?> CreateCustomerAsync(CustomerCreateDto customer)
    {
        var foundCustomer = await GetCustomerByEmailAsync(customer.User.Email);

        if (!foundCustomer.User.Email.Equals("") && !foundCustomer.User.Password.Equals(""))
        {
            return null;
        }

        customer = ValidateCreateCustomer(customer);
        
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
        user.Password = customer.User.Password;
        user.Role = customer.User.Role;

        RepeatedField<string> preferences = new RepeatedField<string>();
        foreach(string preference in customer.Preferences)
        {
            preferences.Add(preference);
        }
        try
        {
            var response = await _client.createCustomerAsync(
                new CreateCustomerRequest()
                {
                    User = user,
                    Preference = { preferences }
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
    
    public async Task<List<CustomerDto>> GetAllCustomers()
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

    public async Task<CustomerDto?> ValidateCustomer(string username, string password)
    {
        var customerList = await GetAllCustomers();
        
        var existingCustomer = customerList.FirstOrDefault(u => 
            u.User.Email.Equals(username, StringComparison.OrdinalIgnoreCase));
        
        return existingCustomer;
    }

    private CustomerCreateDto ValidateCreateCustomer(CustomerCreateDto customer)
    {
        if (string.IsNullOrEmpty(customer.User.Email))
        {
            throw new ValidationException("Username cannot be null");
        }

        if (string.IsNullOrEmpty(customer.User.Password))
        {
            throw new ValidationException("Password cannot be null");
        }

        return customer;
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
        user.Password = response.User.Password;
        
        List<string> preferences = new List<string>();

        IEnumerator<string> em = response.Preference.GetEnumerator();

        while(em.MoveNext())
        {
            preferences.Add(em.Current);
        }

        return new CustomerDto()
        {
            User = user,
            Preferences = preferences
        };
    }

}