namespace Domain.Models;

public class SellerModel
{
    public UserModel User { get; set; }
    public int Cvr { get; set; }
    public string CompanyName { get; set; }
    public string Description { get; set; }
    public string Type { get; set; }
    public string Website { get; set; }
    public float Rating { get; set; }

    public string Image{get;set;}
}

public class SellerCreateModel
{
    public UserCreateModel User { get; set; }
    public int Cvr { get; set; }
    public string CompanyName { get; set; }
    public string Description { get; set; }
    public string Type { get; set; }
    public string Website { get; set; }
    public float Rating { get; set; }

    public string Image {get;set;}
}