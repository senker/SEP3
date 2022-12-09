using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class FoodPackHttpClient : IFoodPackService
{
    
    private readonly HttpClient client;

    public FoodPackHttpClient(HttpClient client)
    {
        this.client = client;
    }


    public async Task<List<FoodPackModel>> GetFoodPacksBySellerCvr(int cvr)
    {
        string url = "/by-seller-cvr/"+cvr;

        HttpResponseMessage response = await client.GetAsync(url);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("status code not equal to 200");
        }
        Console.WriteLine(result);

        List<FoodPackModel> foodPackModels = JsonSerializer.Deserialize<List<FoodPackModel>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        Console.Write("food pack models: ");
        Console.WriteLine(foodPackModels);
        return foodPackModels;
    }

    public async Task<FoodPackModel> PostFoodPack(FoodPackCreateDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/FoodPack", dto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        FoodPackModel foodPackModel = JsonSerializer.Deserialize<FoodPackModel>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return foodPackModel;
    }

    public async Task<List<FoodPackModel>> SearchFoodPacks(SearchFoodPackDto dto)
    {
        string url = $"{dto.IsPrepared + "/" + dto.Title + "/" + dto.Type + "/" + dto.Price + "/" + dto.PostCode}";
        HttpResponseMessage response = await client.GetAsync(url);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("status code not equal to 200");
        }
        Console.WriteLine(result);

        List<FoodPackModel> foodPackModels = JsonSerializer.Deserialize<List<FoodPackModel>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return foodPackModels;
    }
}