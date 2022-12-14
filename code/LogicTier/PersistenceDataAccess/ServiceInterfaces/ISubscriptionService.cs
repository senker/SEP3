using Domain.DTOs;

namespace PersistenceDataAccess.ServiceInterfaces;

public interface ISubscriptionService
{
    Task<SubscriptionDto> CreateSubscriptionAsync(SubscriptionDto dto);
}