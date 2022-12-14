using Domain.DTOs;

namespace Application.ServiceInterfaces;

public interface IReservationService
{
    Task<ReservationDto> CreateReservationDaoAsync(ReservationCreateDto dto);
    Task<List<ReservationDto>> GetReservationsBySellerCvrDaoAsync(int cvr);
    Task<List<ReservationDto>> GetReservationsByCustomerEmailDaoAsync(String email);
}