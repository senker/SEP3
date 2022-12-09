using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IFoodPackService
{
    Task<List<FoodPackModel>> GetFoodPacksBySellerCvr(int cvr);
    Task<FoodPackModel> PostFoodPack(FoodPackCreateDto dto);

    Task<List<FoodPackModel>> SearchFoodPacks(SearchFoodPackDto dto);
}