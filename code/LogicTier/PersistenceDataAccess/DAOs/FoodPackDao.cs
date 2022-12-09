using System.Collections;
using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using FoodPack;
using Grpc.Core;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
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
        string json = @"'"+foodPack.StartTime+"'";


       // DateTime startDateTime = DateTime.Parse(foodPack.StartTime);
        //DateTime endDateTime = DateTime.Parse(foodPack.EndTime);

        var format = "MM/dd/yyyy HH:mm:ss";
        var dateTimeConverter = new IsoDateTimeConverter { DateTimeFormat = format };

        var  startDateTime  = JsonConvert.DeserializeObject<DateTime>(json, 
           dateTimeConverter); 
        var endDateTime = JsonConvert.DeserializeObject<DateTime>(json, dateTimeConverter);


        Console.WriteLine(startDateTime);
        Console.WriteLine(startDateTime.Year);
        Console.WriteLine(startDateTime.Month);
        Console.WriteLine(startDateTime.Day);
        Console.WriteLine(startDateTime.Hour);
        Console.WriteLine(startDateTime.Minute);

            DateTimeFoodPack startDateTimeFoodPackModel = new DateTimeFoodPack()
        {
            Year = startDateTime.Year,
            Month = startDateTime.Month,
            Day = startDateTime.Day,
            Hour = startDateTime.Hour,
            Minutes = startDateTime.Minute
        };

        DateTimeFoodPack endDateTimeFoodPackModel = new DateTimeFoodPack()
        {
            Year = endDateTime.Year,
            Month = endDateTime.Month,
            Day = endDateTime.Day,
            Hour = endDateTime.Hour,
            Minutes = endDateTime.Minute
        };
        try
        {
            var response =  await _client.createFoodPackAsync(
                new CreateFoodPackRequest
                {
                    Cvr = foodPack.Cvr,
                    Title = foodPack.Title,
                    Description = foodPack.Description,
                    Type = foodPack.Type,
                    IsPrepared = foodPack.IsPrepared,
                    StartTime = startDateTimeFoodPackModel,
                    EndTime = endDateTimeFoodPackModel,
                    Price = foodPack.Price
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
        //year, month, day, hour, minute, second
        DateTime startDateTime = new DateTime(response.StartTime.Year, response.StartTime.Month, response.StartTime.Day, response.StartTime.Hour, response.StartTime.Minutes, 0);
        DateTime endDateTime = new DateTime(response.EndTime.Year, response.EndTime.Month, response.EndTime.Day, response.EndTime.Hour, response.EndTime.Minutes, 0);


        return new FoodPackDto
        {
            Id = response.Id,
            Title = response.Title,
            Description = response.Description,
            Type = response.Type,
            IsPrepared = response.IsPrepared,
            StartTime = startDateTime.ToString(),
            EndTime = endDateTime.ToString(),
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