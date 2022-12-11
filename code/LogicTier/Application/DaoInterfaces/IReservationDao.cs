using Domain.DTOs;

namespace Application.DaoInterfaces;

public interface IReservationDao
{
    Task<ReservationDto> CreateReservationDaoAsync(ReservationCreateDto dto);
    Task<List<ReservationDto>> GetReservationsBySellerCvrDaoAsync(int cvr);
    Task<List<ReservationDto>> GetReservationsByCustomerEmailDaoAsync(String email);
}