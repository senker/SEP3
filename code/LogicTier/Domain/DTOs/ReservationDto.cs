namespace Domain.DTOs;

public class ReservationDto
{
    public int Id {get;set;}
    public string Status {get;set;}
    //public int foodPack_id;
    //public string customer_id ;
    public string StartPickupTime {get;set;}
    public string EndPickupTime {get;set;}
    //int cvr = 7;
}

public class ReservationCreateDto
{
    public int CustomerId {get;set;}
    public int FoodPackId {get;set;}
}