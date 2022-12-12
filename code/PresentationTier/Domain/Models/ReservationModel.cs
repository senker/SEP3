namespace Domain.Models;

public class ReservationModel
{
    public String Status {get;set;}
    public FoodPackModel FoodPack {get;set;}
    public String CustomerId {get;set;}
    public int Cvr {get;set;}
    public String FullAddress{get;set;}
}

public class ReservationCreateModel
{
    public FoodPackModel FoodPack {get;set;}
    public String CustomerId {get;set;}

    public ReservationCreateModel(FoodPackModel foodPack, string customerId)
    {
        FoodPack = foodPack;
        CustomerId = customerId;
    }
}