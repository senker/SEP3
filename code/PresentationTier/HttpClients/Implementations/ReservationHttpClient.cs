using System.Text.Json;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class ReservationHttpClient : IReservationService
{

    private readonly HttpClient client;

    public ReservationHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task<List<ReservationModel>> GetReservationsBySellerCvr(int cvr)
    {
        HttpResponseMessage response = await client.GetAsync("/by-seller/" + cvr);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        List<ReservationModel> reservationModels = JsonSerializer.Deserialize<List<ReservationModel>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return reservationModels;
    }

    public async Task<List<ReservationModel>> GetReservationsByCustomerEmail(String email)
    {
        HttpResponseMessage response = await client.GetAsync("/by-customer/"+email);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        List<ReservationModel> reservationModels = JsonSerializer.Deserialize<List<ReservationModel>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return reservationModels;
    }
}