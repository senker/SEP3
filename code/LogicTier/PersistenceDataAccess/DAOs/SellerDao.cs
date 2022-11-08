using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using static PersistenceDataAccess.SellerService;
namespace PersistenceDataAccess.DAOs;

public class SellerDao : ISellerDao
{
    private readonly SellerServiceClient _client;
    public async Task<SellerModel> CreateSellerAsync(SellerModel seller)
    {
        throw new NotImplementedException();
    }

    public Task<SellerModel?> GetByEmailAsync(string userName)
    {
        throw new NotImplementedException();
    }

    public Task<IEnumerable<SellerModel>> GetAsync(SearchSellerParametersDto searchParameters)
    {
        throw new NotImplementedException();
    }
}