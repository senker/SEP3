using Application.DaoInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class FoodPackController : ControllerBase
{
    private readonly IFoodPackDao _foodPackDao;
    
    public FoodPackController(IFoodPackDao foodPackDao)
    {
        _foodPackDao = foodPackDao;
    }
    
    [HttpPost]
    [Route("/food-pack")]
    public async Task<ActionResult> CreateFoodPack([FromBody] FoodPackCreateDto foodPack)
    {
        try
        {
            return Ok();
        }
        catch(Exception e)
        {
            return   e.Message;
        }
        return Ok()
       // return Ok(await _foodPackDao.CreateFoodPackAsync(foodPack));
    }
    
    [HttpGet("{id}")]
    public async Task<IActionResult> GetFoodPackById(int id)
    {
        var foodPack = await _foodPackDao.GetFoodPackByIdAsync(id);

        if (foodPack == null)
            return NotFound("Food pack not found");

        return Ok(foodPack);
    }

    [HttpGet("{isPrepared}/{title}/{type}/{price}/{postcode}")]
    public async Task<IActionResult> SearchFoodPacks(bool isPrepared,  string title,
    string type, double price, int postcode)
    {

        var foodPacks = await _foodPackDao.SearchFoodPacks(isPrepared, title,  type, price, postcode);
        return Ok(foodPacks);
    }

    [HttpGet]
    [Route("/by-seller-cvr/{cvr}")]
    public async Task<IActionResult> GetFoodPacksBySellerCvr(int cvr)
    {
        var foodPacks = await _foodPackDao.GetFoodPacksBySellerCvr(cvr);
        return Ok(foodPacks);
    }

    [HttpGet]
    [Route("/all-food-packs")]
    public async Task<IActionResult> GetAllFoodPacks()
    {
        var foodPacks = await _foodPackDao.GetAllFoodPacks();
        return Ok(foodPacks);
    }
    
    
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteFoodPackById(int id)
    {
        return Ok(await _foodPackDao.DeleteFoodPackByIdAsync(id));
    }
}