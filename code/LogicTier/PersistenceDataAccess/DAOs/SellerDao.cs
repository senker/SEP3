using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;
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
    public async Task<SellerDto?> CreateSellerAsync(SellerCreateDto seller)
    {
        AddressModelSeller address = new AddressModelSeller()
        {
            City = seller.User.Address.City,
            StreetName = seller.User.Address.Streetname,
            PostCode = seller.User.Address.Postcode
        };

        CreateUserModelRequestSeller user = new CreateUserModelRequestSeller();
        user.FirstName = seller.User.FirstName;
        user.LastName = seller.User.LastName;
        user.Address = address;
        user.PhoneNumber = seller.User.PhoneNumber;
        user.Email = seller.User.Email;
        user.Password = seller.User.Password;
        
        try
        {
            var response =  await _client.createSellerAsync(
                new CreateSellerRequest()
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

            return ResponseToSellerDto(response);
        }
        catch (Exception e)
        {
            Console.WriteLine("{0} Exception caught.", e);
            throw new Exception("",e);

        }
    }

    private SellerDto ResponseToSellerDto(SellerResponse response)
    {
        var address = new Domain.Models.AddressModel
        {
            City = response.User.Address.City,
            Streetname = response.User.Address.StreetName,
            Postcode = response.User.Address.PostCode
        };

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

    public async Task<SellerDto?> GetSellerByCvrAsync(int cvr)
    {
        try
        {
            var response = await _client.getSellerByCvrAsync(
                new SellerRequest{ Id = cvr }
            );

            return ResponseToSellerDto(response);
        }
        catch
        {
            throw new Exception("Couldn't get the cvr");
        }
    }


  public async  Task<List<SellerDto>> GetAllSellers()
    {
        try
        {
            List<SellerDto> sellerList = new List<SellerDto>();
            AsyncServerStreamingCall<SellerResponse> response = _client.getAllSellers(new EmptySeller());
            while (await response.ResponseStream.MoveNext())
            {
                SellerResponse current = response.ResponseStream.Current;
                sellerList.Add(ResponseToSellerDto(current));
            }

            return sellerList;
        }
        catch
        {
            throw new Exception("Couldn't load all sellers");
        }
    }

  public Task<SellerDto> GetSeller(string username, string password)
  {
      throw new NotImplementedException();
  }

  public Task RegisterSeller(SellerDto seller)
  {
      throw new NotImplementedException();
  }

  public async Task<SellerDto?> DeleteSellerByCvrAsync(int cvr)
    {
        try
        {
            var response = await _client.deleteSellerByCvrAsync(
                new SellerRequest { Id = cvr }
            );

            return ResponseToSellerDto(response);
        }
        catch
        {
            return null;
        }
    }
}