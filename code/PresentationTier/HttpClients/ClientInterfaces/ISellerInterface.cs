using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ISellerInterface
{
    Task<SellerModel> CreateSeller(SellerCreateDto dto);
}