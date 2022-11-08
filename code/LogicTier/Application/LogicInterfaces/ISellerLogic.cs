using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterfaces;

public interface ISellerLogic
{
    Task<SellerDto> CreateSellerAsync(SellerDto userToCreate);
    public Task<IEnumerable<SellerDto>> GetAsync(SearchSellerParametersDto searchParameters);
}