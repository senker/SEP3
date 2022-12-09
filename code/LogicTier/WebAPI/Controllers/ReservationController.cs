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
    public async Task<ActionResult> CreateFoodPack(ReservationCreateDto foodPack)
    {
        return Ok(await _reservationDao.CreateReservationDaoAsync(foodPack));
    }
}