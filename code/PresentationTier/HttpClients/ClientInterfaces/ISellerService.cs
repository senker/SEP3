using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ISellerService
{
    Task<SellerModel> CreateSeller(SellerCreateDto dto);
    Task<List<SellerModel>> GetSellers();
    Task<SellerModel> GetSellerByCvr(int cvr);
    Task<string> GetImage();
}