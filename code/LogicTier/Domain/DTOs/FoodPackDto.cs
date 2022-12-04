namespace Domain.DTOs;

public class FoodPackDto
{
    public int Id { get; set; }
    public String Title { get; set; }
    public String Description { get; set; }
    public String Type { get; set; }
    public bool IsPrepared { get; set; }
    public double Price { get; set; }

    public FoodPackDto(int id, string title, string description, string type, bool isPrepared, double price)
    {
        Id = id;
        Title = title;
        Description = description;
        Type = type;
        IsPrepared = isPrepared;
        Price = price;
    }
}

public class FoodPackCreateDto
{
    public String Title { get; set; }
    public String Description { get; set; }
    public String Type { get; set; }
    public bool IsPrepared { get; set; }
    public double Price { get; set; }

    public FoodPackCreateDto(string title, string description, string type, bool isPrepared, double price)
    {
        Title = title;
        Description = description;
        Type = type;
        IsPrepared = isPrepared;
        Price = price;
    }
}