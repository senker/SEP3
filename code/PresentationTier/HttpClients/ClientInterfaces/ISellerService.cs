using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ISellerService
{
    Task<SellerModel> CreateSeller(SellerCreateDto dto);
    Task<List<SellerModel>> GetSellers();
    Task<string> GetImage();
}