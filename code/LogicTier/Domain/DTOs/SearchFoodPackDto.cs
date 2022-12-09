using System.Net.Mime;
using Domain.Models;

namespace Domain.DTOs;

public class SearchFoodPackDto
{
    public String Title {get;set;}
    public bool IsPrepared {get;set;}
    public String Type {get;set;}
    public double Price {get;set;}
    public int PostCode {get;set;}

    public SearchFoodPackDto() {
    }

    public SearchFoodPackDto(SearchFoodPackModel foodPackModel) =>
        (Title, IsPrepared, Type, Price, PostCode) = (
            foodPackModel.Title, foodPackModel.IsPrepared, foodPackModel.Type, foodPackModel.Price, foodPackModel.PostCode);
}