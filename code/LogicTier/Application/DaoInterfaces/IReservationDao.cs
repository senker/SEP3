using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface IReservationDao
{
    Task<ReservationDto> CreateReservationDaoAsync(ReservationCreateDto dto);
}