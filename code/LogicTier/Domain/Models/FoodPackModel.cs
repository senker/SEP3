namespace Domain.Models;

public class FoodPackModel
{
    public int Id { get; set; }
    public String Title { get; set; }
    public String Description { get; set; }
    public String Type { get; set; }
    public bool IsPrepared { get; set; }
    public double Price { get; set; }

    public DateTime StartTime{get;set;}
    
    public DateTime EndTime{get;set;}
}

public class FoodPackCreateModel
{
    public String Title { get; set; }
    public String Description { get; set; }
    public String Type { get; set; }
    public bool IsPrepared { get; set; }
    public double Price { get; set; }

    public DateTime StartTime{get;set;}
    
    public DateTime EndTime{get;set;}
    public int Cvr{get;set;}
}
