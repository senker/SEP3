using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface IFoodPackDao
{
    Task<FoodPackDto?> CreateFoodPackAsync(FoodPackCreateDto seller);
    Task<FoodPackDto?> GetFoodPackByIdAsync(int id);

    Task<List<FoodPackDto>> SearchFoodPacks(bool isPrepared,  string title,
        string type, double price, int postcode);
    Task<FoodPackDto?> DeleteFoodPackByIdAsync(int id);

    Task<List<FoodPackDto>> GetFoodPacksBySellerCvr(int cvr);
    Task<List<FoodPackDto>> GetAllFoodPacks();
}