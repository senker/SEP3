using Application.DaoInterfaces;
using Domain.DTOs;
using PersistenceDataAccess.Services;
using Grpc.Core;

namespace PersistenceDataAccess.DAOs;

public class ReservationDao : IReservationDao
{
     private readonly ReservationService.ReservationServiceClient _client;

     public ReservationDao(IGrpcService grpcService)
     {
         _client = new ReservationService.ReservationServiceClient(grpcService.GetChannel());
     }

    public async Task<ReservationDto> CreateReservationDaoAsync(ReservationCreateDto dto)
    {
        try
        {
            var response =  await _client.createReservationAsync(
                new CreateReservationRequest()
                {
                    CustomerId = dto.CustomerId,
                    FoodPackId = dto.FoodPackId
                }
            );

            return ResponseToReservationDto(response);
        }
        catch (Exception e)
        {
            Console.WriteLine("{0} Exception caught.", e);
            throw new Exception("",e);

        }
    }

    public async Task<List<ReservationDto>> GetReservationsBySellerCvrDaoAsync(int cvr)
    {
        try
        {
            List<ReservationDto> reservationList = new List<ReservationDto>();
            AsyncServerStreamingCall<ReservationResponse> response =  _client.getReservationsBySellerCvr(
                new ReservationSellerRequest{Cvr=cvr});
            while (await response.ResponseStream.MoveNext())
            {
                ReservationResponse current = response.ResponseStream.Current;
                reservationList.Add(ResponseToReservationDto(current));
            }

            return reservationList;
        }
        catch(Exception e)
        {
            throw new Exception("Couldn't load all reservations");
        }
    }

    public async Task<List<ReservationDto>> GetReservationsByCustomerEmailDaoAsync(string email)
    {
        try
        {
            List<ReservationDto> reservationList = new List<ReservationDto>();
            AsyncServerStreamingCall<ReservationResponse> response =  _client.getReservationsByCustomerEmail(
                new ReservationCustomerRequest{Email=email});
            while (await response.ResponseStream.MoveNext())
            {
                ReservationResponse current = response.ResponseStream.Current;
                reservationList.Add(ResponseToReservationDto(current));
            }

            return reservationList;
        }
        catch(Exception e)
        {
            throw new Exception("Couldn't load all reservations");
        }
    }

    private ReservationDto ResponseToReservationDto(ReservationResponse response)
    {
        /*
  int32 id = 1;
  string status = 2;
  int32 foodPack_id = 3;
  string customer_id = 4;
  string startPickupTime = 5;
  string endPickupTime = 6;
  int32 cvr = 7;
         *
         */

        return new ReservationDto()
        {
            Status = response.Status,
            FoodPack = new FoodPackDto
            {
                Id = response.FoodPack.Id,
                Title = response.FoodPack.Title,
                Description = response.FoodPack.Description,
                Type = response.FoodPack.Type,
                IsPrepared = response.FoodPack.IsPrepared,
                Price = response.FoodPack.Price,
                StartTime = DateTime.Parse(response.FoodPack.StartPickupTime),
                EndTime = DateTime.Parse(response.FoodPack.EndPickupTime)          
            },
             CustomerId = response.CustomerId,
             Cvr = response.Cvr,
             FullAddress = response.FullAddress

        };
    }
}