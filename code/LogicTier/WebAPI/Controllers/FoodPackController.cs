using System.Security.Claims;
using Application.ServiceInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using WastelessWASM;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class FoodPackController : ControllerBase
{
    private readonly IFoodPackService _foodPackService;
    
    public FoodPackController(IFoodPackService foodPackService)
    {
        _foodPackService = foodPackService;
    }
    
    [HttpPost()]
    public async Task<ActionResult> CreateFoodPack(FoodPackCreateDto foodPack)
    {
        return Ok(await _foodPackService.CreateFoodPackAsync(foodPack));
    }
    
    [HttpGet("{id}")]
    public async Task<IActionResult> GetFoodPackById(int id)
    {
        var foodPack = await _foodPackService.GetFoodPackByIdAsync(id);

        if (foodPack == null)
            return NotFound("Food pack not found");

        return Ok(foodPack);
    }

    [Microsoft.AspNetCore.Mvc.HttpGet("{isPrepared}/{title}/{type}/{price}/{postcode}")]
    public async Task<IActionResult> SearchFoodPacks(bool isPrepared,  string title,
    string type, double price, int postcode)
    {

        var foodPacks = await _foodPackService.SearchFoodPacks(isPrepared, title,  type, price, postcode);
        return Ok(foodPacks);
    }

    [HttpGet]
    [Route("/by-seller-cvr/{cvr}")]
    public async Task<IActionResult> GetFoodPacksBySellerCvr(int cvr)
    {
        var foodPacks = await _foodPackService.GetFoodPacksBySellerCvr(cvr);
        return Ok(foodPacks);
    }

    [HttpGet]
    [Route("/all-food-packs")]
    public async Task<IActionResult> GetAllFoodPacks()
    {
        var foodPacks = await _foodPackService.GetAllFoodPacks();
        return Ok(foodPacks);
    }
    
    
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteFoodPackById(int id)
    {
        return Ok(await _foodPackService.DeleteFoodPackByIdAsync(id));
    }
}