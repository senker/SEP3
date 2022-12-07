using Application.DaoInterfaces;
using Domain.DTOs;
using Grpc.Core;
using PackPackage;
using PersistenceDataAccess.Services;
using Seller;

namespace PersistenceDataAccess.DAOs;

public class FoodPackDao : IFoodPackDao
{
    private readonly FoodPackService.FoodPackServiceClient _client;
    
    public FoodPackDao(IGrpcService grpcService)
    {
        _client = new FoodPackService.FoodPackServiceClient(grpcService.GetChannel());
    }
    
    public async Task<FoodPackDto?> CreateFoodPackAsync(FoodPackCreateDto foodPack)
    {
        try
        {
            var response =  await _client.createFoodPackAsync(
                new CreateFoodPackRequest
                {
                    Title = foodPack.Title,
                    Description = foodPack.Description,
                    Type = foodPack.Type,
                    IsPrepared = foodPack.IsPrepared,
                    Price = foodPack.Price,
                    Cvr = foodPack.Cvr
                }
            );

            return ResponseToFoodPackDto(response);
        }
        catch (Exception e)
        {
            Console.WriteLine("{0} Exception caught.", e);
            throw new Exception("",e);

        }
    }

    private FoodPackDto ResponseToFoodPackDto(FoodPackResponse response)
    {
        return new FoodPackDto
        {
            Id = response.Id,
            Title = response.Title,
            Description = response.Description,
            Type = response.Type,
            IsPrepared = response.IsPrepared,
            Price = response.Price,
        };
    }


    public async Task<FoodPackDto?> GetFoodPackByIdAsync(int id)
    {
        try
        {
            var response = await _client.getFoodPackByIdAsync(
                new FoodPackRequest { Id = id }
            );

            return ResponseToFoodPackDto(response);
        }
        catch
        {
            throw new Exception("Couldn't get the id");
        }
    }

    public async Task<List<FoodPackDto>> SearchFoodPacks(bool isPrepared, string title, string type, double price, int postcode)
    {
        try
        {
            List<FoodPackDto> foodPackDtoList = new List<FoodPackDto>();
            AsyncServerStreamingCall<FoodPackResponse> response =  _client.searchFoodPacks(
                new SearchFoodPacks
                {
                    IsPrepared = isPrepared, Title = title, Type = type,
                    Price = price, Postcode = postcode
                });
            while (await response.ResponseStream.MoveNext())
            {
                FoodPackResponse current = response.ResponseStream.Current;
                foodPackDtoList.Add(ResponseToFoodPackDto(current));
            }
            return foodPackDtoList; 
        }  
        catch
        {
            throw new Exception("No food packs found");
        }
    }

    public async Task<FoodPackDto?> DeleteFoodPackByIdAsync(int id)
    {
        try
        {
            var response = await _client.deleteFoodPackByIdAsync(
                new FoodPackRequest { Id = id }
            );

            return ResponseToFoodPackDto(response);
        }
        catch
        {
            throw new Exception("Could not delete the food pack");
        }
    }

    public async Task<List<FoodPackDto>> GetFoodPacksBySellerCvr(int cvr)
    {
        try
        {
            List<FoodPackDto> foodPackDto = new List<FoodPackDto>();
            AsyncServerStreamingCall<FoodPackResponse> response = _client.getFoodPacksBySellerCvr(new FoodPackSellerRequest {Cvr = cvr});
            while (await response.ResponseStream.MoveNext())
            {
                FoodPackResponse current = response.ResponseStream.Current;
                foodPackDto.Add(ResponseToFoodPackDto(current));
            }

            return foodPackDto;
        }catch
        {
            throw new Exception("Couldn't load all food packs");
        }
    }

    public async Task<List<FoodPackDto>> GetAllFoodPacks()
    {
        try
        {
            List<FoodPackDto> foodPackDto = new List<FoodPackDto>();
            AsyncServerStreamingCall<FoodPackResponse> response = _client.getAllFoodPacks(new EmptyFoodPack());
            while (await response.ResponseStream.MoveNext())
            {
                FoodPackResponse current = response.ResponseStream.Current;
                foodPackDto.Add(ResponseToFoodPackDto(current));
            }

            return foodPackDto;
        }
        catch
        {
            throw new Exception("Couldn't load all food packs");
        }
    }
}