using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterfaces;

public interface ISellerDao
{
    Task<SellerDto?> CreateSellerAsync(SellerCreateDto seller);
    Task<SellerDto?> GetByIdAsync(int id);
    //public Task<IEnumerable<SellerDto>> GetAsync(SearchSellerParametersDto searchParameters);
}