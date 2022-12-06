using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IFoodPackService
{
    Task<List<FoodPackModel>> GetFoodPacksBySellerCvr(int cvr);
}