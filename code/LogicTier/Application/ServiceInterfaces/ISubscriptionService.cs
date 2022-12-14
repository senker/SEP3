using Domain.DTOs;

namespace Application.ServiceInterfaces;

public interface ISubscriptionService
{
    Task<SubscriptionDto> CreateSubscriptionAsync(SubscriptionDto dto);
}