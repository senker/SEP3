using Domain.DTOs;
using Domain.Models;


public interface ISellerLogic
{
    Task<SellerDto> CreateSellerAsync(SellerDto userToCreate);
    public Task<IEnumerable<SellerDto>> GetAsync(SearchSellerParametersDto searchParameters);
}