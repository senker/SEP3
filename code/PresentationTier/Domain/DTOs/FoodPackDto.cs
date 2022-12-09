using Domain.Models;

namespace Domain.DTOs;

public class FoodPackDto
{
    public int Id { get; set; }
    public String Title { get; set; }
    public String Description { get; set; }
    public String Type { get; set; }
    public bool IsPrepared { get; set; }
    public double Price { get; set; }

    public String StartTime {get;set;}
    public String EndTime{get;set;}


    public FoodPackDto()
    {
    }

    public FoodPackDto(FoodPackModel foodPack) =>
        (Id, Title, Description, Type, IsPrepared, Price) = (
            foodPack.Id, foodPack.Title, foodPack.Description, foodPack.Type, foodPack.IsPrepared, foodPack.Price);
}

public class FoodPackCreateDto
{
    public String Title { get; set; }
    public String Description { get; set; }
    public String Type { get; set; }
    public bool IsPrepared { get; set; }
    public double Price { get; set; }

    public String StartTime {get;set;}

    public String EndTime {get;set;}

    public int Cvr{get;set;}

    public FoodPackCreateDto()
    {
    }

    public FoodPackCreateDto(FoodPackCreateModel foodPack) =>
        (Title, Description, Type, IsPrepared, StartTime, EndTime, Price, Cvr) = (
            foodPack.Title, foodPack.Description, foodPack.Type, foodPack.IsPrepared, foodPack.StartTime, foodPack.EndTime,  foodPack.Price, foodPack.Cvr);
}