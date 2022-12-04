using Application.DaoInterfaces;
using Domain.DTOs;
using PersistenceDataAccess.Services;
using Seller;

namespace PersistenceDataAccess.DAOs;

public class FoodPackDao : IFoodPackDao
{
    private readonly FoodPackService.FoodPackServiceClient _client;
    
    public FoodPackDao(IGrpcService grpcService)
    {
        _client = new FoodPackService.FoodPackServiceClient(grpcService.GetChannel());
    }
    
    public Task<FoodPackDto?> CreateFoodPackAsync(FoodPackCreateDto seller)
    {
        throw new NotImplementedException();
    }

    public Task<FoodPackDto?> GetFoodPackByIdAsync(int id)
    {
        throw new NotImplementedException();
    }

    public Task<FoodPackDto?> DeleteFoodPackByIdAsync(int id)
    {
        throw new NotImplementedException();
    }

    public Task<List<FoodPackDto>> GetAllFoodPacks()
    {
        throw new NotImplementedException();
    }
}