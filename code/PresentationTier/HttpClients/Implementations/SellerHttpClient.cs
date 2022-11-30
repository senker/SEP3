using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class SellerHttpClient : ISellerService
{
    
    private readonly HttpClient client;

    public SellerHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<SellerModel> CreateSeller(SellerCreateDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/seller", dto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        SellerModel seller = JsonSerializer.Deserialize<SellerModel>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return seller;
    }

    public async Task<List<SellerModel>> GetSellers()
    {
        HttpResponseMessage response = await client.GetAsync("/all-sellers");
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        List<SellerModel> sellers = JsonSerializer.Deserialize<List<SellerModel>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return sellers;
    }
}