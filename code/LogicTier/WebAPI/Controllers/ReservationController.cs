using Application.DaoInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class ReservationController : ControllerBase
{
    private readonly IReservationDao _reservationDao;

    public ReservationController(IReservationDao reservation)
    {
        _reservationDao = reservation;
    }

    [HttpPost()]
    public async Task<ActionResult> CreateReservation(ReservationCreateDto foodPack)
    {
        return Ok(await _reservationDao.CreateReservationDaoAsync(foodPack));
    }

    [HttpGet("/by-seller/{cvr}")]
    public async Task<ActionResult> GetReservationsBySellerCvr(int cvr)
    {
        return Ok(await _reservationDao.GetReservationsBySellerCvrDaoAsync(cvr));
    }
    [HttpGet("/by-customer/{email}")]
    public async Task<ActionResult> GetReservationsByCustomerEmail(String email)
    {
        return Ok(await _reservationDao.GetReservationsByCustomerEmailDaoAsync(email));
    }
}