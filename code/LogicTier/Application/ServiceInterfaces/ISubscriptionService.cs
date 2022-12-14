using Domain.DTOs;

namespace Application.ServiceInterfaces;

public interface ISubscriptionService
{
    Task<SubscriptionDto> CreateSubscriptionDaoAsync(SubscriptionDto dto);
}