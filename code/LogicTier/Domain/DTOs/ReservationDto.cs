using Domain.Models;

namespace Domain.DTOs;

public class ReservationDto
{
    public String Status {get;set;}
    public FoodPackDto FoodPack {get;set;}
    public String CustomerId {get;set;}
    public int Cvr {get;set;}
    public String FullAddress {get;set;}
}

public class ReservationCreateDto
{
    public string CustomerId {get;set;}
    public int FoodPackId {get;set;}

}