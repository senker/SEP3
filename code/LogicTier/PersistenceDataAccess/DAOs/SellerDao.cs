using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;
using PersistenceDataAccess.Services;
using Seller;
namespace PersistenceDataAccess.DAOs;

public class SellerDao : ISellerDao
{
    private readonly SellerService.SellerServiceClient _client;
    
    public SellerDao(IGrpcService grpcService)
    {
        _client = new SellerService.SellerServiceClient(grpcService.GetChannel());
    }
    public async Task<SellerDto?> CreateSellerAsync(SellerCreateDto seller)
    {
        // TODO: we have to implement getSellerByEmail and use it in this context
        var foundSeller = await GetSellerByCvrAsync(seller.Cvr);

        if (foundSeller != null) return null;
        
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
        user.Role = seller.User.Role;

        ImageModelRequestSeller image = new ImageModelRequestSeller();
        image.ImageUrl = seller.Image;
        
        try
        {
            var response =  await _client.createSellerAsync(
                new CreateSellerRequest()
                {
                    User = user,
                    Cvr = seller.Cvr,
                    CompanyName = seller.CompanyName,
                    Description = seller.Description,
                    Type = seller.Type,
                    Website = seller.Website,
                    Rating = seller.Rating,
                    Image = image
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
            Website = response.Website,
            Image = response.Image.ImageUrl
        };
    }

    public async Task<SellerDto?> GetSellerByCvrAsync(int cvr)
    {
        try
        {
            var response = await _client.getSellerByCvrAsync(
                new SellerRequest{ Cvr = cvr }
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

  public async Task<SellerDto?> ValidateSeller(string username, string password)
  {
      var sellerList = await GetAllSellers();
      var existingSeller = sellerList.FirstOrDefault(u => 
          u.User.Email.Equals(username, StringComparison.OrdinalIgnoreCase));

      return existingSeller;
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
                new SellerRequest { Cvr = cvr }
            );

            return ResponseToSellerDto(response);
        }
        catch
        {
            throw new Exception("Could not delete the seller");
        }
    }
}