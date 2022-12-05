using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface IFoodPackDao
{
    Task<FoodPackDto?> CreateFoodPackAsync(FoodPackCreateDto seller);
    Task<FoodPackDto?> GetFoodPackByIdAsync(int id);
    Task<FoodPackDto?> DeleteFoodPackByIdAsync(int id);
    Task<List<FoodPackDto>> GetAllFoodPacks();
}