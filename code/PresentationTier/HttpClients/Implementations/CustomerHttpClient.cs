using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class CustomerHttpClient : ICustomerService
{
    
    private readonly HttpClient client;

    public CustomerHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<CustomerModel> CreateCustomer(CustomerCreateDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/customer", dto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        CustomerModel customer = JsonSerializer.Deserialize<CustomerModel>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return customer;
    }
}