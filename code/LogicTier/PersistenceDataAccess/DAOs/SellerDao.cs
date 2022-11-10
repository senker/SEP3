using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using PersistenceDataAccess.Services;
using static PersistenceDataAccess.SellerService;
namespace PersistenceDataAccess.DAOs;

public class SellerDao : ISellerDao
{
    private readonly SellerServiceClient _client;
    
    public SellerDao(IGrpcService grpcService)
    {
        _client = new SellerServiceClient(grpcService.GetChannel());
    }
    public async Task<SellerDto> CreateSellerAsync(SellerModel seller)
    {
        AddressModel address = new AddressModel
        {
            City = seller.User.Address.City,
            StreetName = seller.User.Address.Streetname,
            PostCode = seller.User.Address.Postcode
        };

        CreateUserModelResponse user = new CreateUserModelResponse();
        user.FirstName = seller.User.FirstName;
        user.LastName = seller.User.LastName;
        user.Address = address;
        user.PhoneNumber = seller.User.PhoneNumber;
        user.Email = seller.User.Email;
        
        try
        {
            var response = await _client.createSellerAsync(
                new CreateSellerResponse
                {
                    User = user,
                    CompanyName = seller.CompanyName,
                    Cvr = seller.Cvr,
                    Description = seller.Description,
                    Rating = seller.Rating,
                    Type = seller.Type,
                    Website = seller.Website
                }
            );

            return responseToSellerDto(response);
        }
        catch
        {
            throw new Exception("Failed to connect to the gRPC client");
        }
    }

    private SellerDto responseToSellerDto(SellerResponse response)
    {
        Domain.Models.AddressModel address = new Domain.Models.AddressModel();
        address.City = response.User.Address.City;
        address.Streetname = response.User.Address.StreetName;
        address.Postcode = response.User.Address.PostCode;

        UserModel user = new UserModel();
        user.Id = response.User.Id;
        user.FirstName = response.User.FirstName;
        user.LastName = response.User.LastName;
        user.Address = address;
        user.PhoneNumber = response.User.PhoneNumber;
        user.Email = response.User.Email;
        
        return new SellerDto
        {
            User = user,
            Cvr = response.Cvr,
            CompanyName = response.CompanyName,
            Description = response.Description,
            Rating = response.Rating,
            Type = response.Type,
            Website = response.Website
        };
    }

    public async Task<SellerDto?> GetByIdAsync(int id)
    {
        return null;
    }

    public Task<IEnumerable<SellerDto>> GetAsync(SearchSellerParametersDto searchParameters)
    {
        throw new NotImplementedException();
    }
}