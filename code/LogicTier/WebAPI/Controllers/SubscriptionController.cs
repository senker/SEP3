﻿using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;
using PersistenceDataAccess.ServiceInterfaces;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class SubscriptionController : ControllerBase
{
    private readonly ISubscriptionService _subscriptionService;

    public SubscriptionController(ISubscriptionService subscriptionService)
    {
        _subscriptionService = subscriptionService;
    }

    [HttpPost()]
    public async Task<ActionResult> CreateSubscription(SubscriptionDto subscription)
    {
        return Ok(await _subscriptionService.CreateSubscriptionAsync(subscription));
    }
}