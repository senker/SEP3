using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterfaces;

public interface ISellerDao
{
    Task<SellerModel> CreateSellerAsync(SellerModel seller);
    Task<SellerModel?> GetByEmailAsync(string userName);
    public Task<IEnumerable<SellerModel>> GetAsync(SearchSellerParametersDto searchParameters);
}