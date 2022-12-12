using Application.DaoInterfaces;
using Domain.DTOs;
using PersistenceDataAccess.Services;
using Reservation;

namespace PersistenceDataAccess.DAOs;

public class SubscriptionDao : ISubscriptionDao
{

    private readonly SubscriptionService.SubscriptionServiceClient _client;

    public SubscriptionDao(IGrpcService grpcService)
    {
        _client = new SubscriptionService.SubscriptionServiceClient(grpcService.GetChannel());
    }

    public async Task<SubscriptionDto> CreateSubscriptionDaoAsync(SubscriptionDto dto)
    {
        try
        {
            var response = await _client.createSubscriptionAsync(
                new CreateSubscriptionRequest()
                {
                    CustomerEmail = dto.Email,
                    Cvr = dto.Cvr
                }
            );

            return ResponseToSubscriptionDto(response);
        }
        catch (Exception e)
        {
            Console.WriteLine("{0} Exception caught.", e);
            throw new Exception("",e);

        }


    }

    private SubscriptionDto ResponseToSubscriptionDto(CreateSubscriptionResponse response)
    {
        return new SubscriptionDto()
        {
            Email = response.CustomerEmail,
            Cvr = response.Cvr
        };
    }
}