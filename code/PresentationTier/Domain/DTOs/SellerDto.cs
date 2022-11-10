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

    public SellerDto() {
    }

    public SellerDto(SellerModel seller) =>
        (User, Cvr, CompanyName, Description, Type, Website, Rating) = (
            seller.User, seller.Cvr, seller.CompanyName, seller.Description, seller.Type, seller.Website, seller.Rating);
}

public class SearchSellerParametersDto
{
    public string? SellerContains { get; }

    public SearchSellerParametersDto(string? sellerContains)
    {
        SellerContains = sellerContains;
    }
}
