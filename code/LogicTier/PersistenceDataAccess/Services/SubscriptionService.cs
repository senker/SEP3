using Application.ServiceInterfaces;
using Domain.DTOs;
using PersistenceDataAccess.Services;
namespace PersistenceDataAccess.Services;

public class SubscriptionService : ISubscriptionService
{

    private readonly PersistenceDataAccess.SubscriptionService.SubscriptionServiceClient _client;

    public SubscriptionService(IGrpcService grpcService)
    {
        _client = new PersistenceDataAccess.SubscriptionService.SubscriptionServiceClient(grpcService.GetChannel());
    }

    public async Task<SubscriptionDto> CreateSubscriptionAsync(SubscriptionDto dto)
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