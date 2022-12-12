using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface ISubscriptionDao
{
    Task<SubscriptionDto> CreateSubscriptionDaoAsync(SubscriptionDto dto);
}