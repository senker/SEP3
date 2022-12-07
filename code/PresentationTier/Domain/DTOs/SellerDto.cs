namespace Domain.DTOs;
using Domain.Models;

public class SellerDto
{
    public UserModel User { get; set; }
    public int Cvr { get; set; }
    public string CompanyName { get; set; }
    public string Description { get; set; }
    public string Type { get; set; }
    public string Website { get; set; }
    public float Rating { get; set; }
    public string Image{get;set;}

    public SellerDto() {
    }

    public SellerDto(SellerModel seller) =>
        (User, Cvr, CompanyName, Description, Type, Website, Rating, Image) = (
            seller.User, seller.Cvr, seller.CompanyName, seller.Description, seller.Type, seller.Website, seller.Rating, seller.Image);
}

public class SellerCreateDto
{
    public UserCreateModel User { get; set; }
    public int Cvr { get; set; }
    public string CompanyName { get; set; }
    public string Description { get; set; }
    public string Type { get; set; }
    public string Website { get; set; }
    public float Rating { get; set; }
    public string Image {get;set;}

    public SellerCreateDto() {
    }

    public SellerCreateDto(SellerCreateModel seller) =>
        (User, Cvr, CompanyName, Description, Type, Website, Rating, Image) = (
            seller.User, seller.Cvr, seller.CompanyName, seller.Description, seller.Type, seller.Website, seller.Rating, seller.Image);
}