namespace Domain.DTOs;
using Domain.Models;

public class SellerDto
{
    public int Cvr { get; set; }
    public string CompanyName { get; set; }
    public string Description { get; set; }
    public string Type { get; set; }
    public string Website { get; set; }
    public float Rating { get; set; }

    public SellerDto() {
    }

    public SellerDto(SellerModel seller) =>
        (Cvr, CompanyName, Description, Type, Website, Rating) = (
            seller.Cvr, seller.CompanyName, seller.Description, seller.Type, seller.Website, seller.Rating);
}
