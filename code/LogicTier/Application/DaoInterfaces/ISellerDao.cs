using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterfaces;

public interface ISellerDao
{
    Task<SellerDto?> CreateSellerAsync(SellerCreateDto seller);
    Task<SellerDto?> GetSellerByCvrAsync(int cvr);
    Task<SellerDto?> DeleteSellerByCvrAsync(int cvr);
}