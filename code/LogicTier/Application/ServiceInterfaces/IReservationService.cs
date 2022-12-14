﻿using Domain.DTOs;

namespace Application.ServiceInterfaces;

public interface IReservationService
{
    Task<ReservationDto> CreateReservationAsync(ReservationCreateDto dto);
    Task<List<ReservationDto>> GetReservationsBySellerCvrAsync(int cvr);
    Task<List<ReservationDto>> GetReservationsByCustomerEmailAsync(String email);
}