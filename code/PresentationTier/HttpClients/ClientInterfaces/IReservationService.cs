using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IReservationService
{
    Task<List<ReservationModel>> GetReservationsBySellerCvr(int cvr);
    Task<List<ReservationModel>> GetReservationsByCustomerEmail(String email);
}