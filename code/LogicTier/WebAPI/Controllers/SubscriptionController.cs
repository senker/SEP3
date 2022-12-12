using Application.DaoInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class SubscriptionController : ControllerBase
{
    private readonly ISubscriptionDao _subscriptionDao;

    public SubscriptionController(ISubscriptionDao subscriptionDao)
    {
        _subscriptionDao = subscriptionDao;
    }

    [HttpPost()]
    public async Task<ActionResult> CreateSubscription(SubscriptionDto subscription)
    {
        return Ok(await _subscriptionDao.CreateSubscriptionDaoAsync(subscription));
    }
}