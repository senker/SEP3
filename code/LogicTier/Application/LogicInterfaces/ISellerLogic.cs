using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterfaces;

public interface ISellerLogic
{
    Task<SellerModel> CreateSellerAsync(SellerDto userToCreate);
    public Task<IEnumerable<SellerModel>> GetAsync(SearchSellerParametersDto searchParameters);
}