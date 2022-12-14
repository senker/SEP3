using Domain.DTOs;
using Grpc.Core;

namespace Application.ServiceInterfaces;


public interface ISellerService 
{
    Task<SellerDto?> CreateSellerAsync(SellerCreateDto seller);
    Task<SellerDto?> GetSellerByCvrAsync(int cvr);
    Task<SellerDto?> DeleteSellerByCvrAsync(int cvr);
    Task<List<SellerDto>> GetAllSellers();
    Task<SellerDto?> ValidateSeller(string username, string password);
}