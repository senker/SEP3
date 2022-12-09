using Application.DaoInterfaces;
using Domain.DTOs;
using PersistenceDataAccess.Services;
using Grpc.Core;
using Reservation;

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
            Id = response.Id,
            Status = response.Status,
            StartPickupTime = response.StartPickupTime,
            EndPickupTime = response.EndPickupTime
        };
    }
}