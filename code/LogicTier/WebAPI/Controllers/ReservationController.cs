using Application.ServiceInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class ReservationController : ControllerBase
{
    private readonly IReservationService _reservationService;

    public ReservationController(IReservationService reservation)
    {
        _reservationService = reservation;
    }

    [HttpPost()]
    public async Task<ActionResult> CreateReservation(ReservationCreateDto foodPack)
    {
        return Ok(await _reservationService.CreateReservationDaoAsync(foodPack));
    }

    [HttpGet("/by-seller/{cvr}")]
    public async Task<ActionResult> GetReservationsBySellerCvr(int cvr)
    {
        return Ok(await _reservationService.GetReservationsBySellerCvrDaoAsync(cvr));
    }
    [HttpGet("/by-customer/{email}")]
    public async Task<ActionResult> GetReservationsByCustomerEmail(String email)
    {
        return Ok(await _reservationService.GetReservationsByCustomerEmailDaoAsync(email));
    }
}