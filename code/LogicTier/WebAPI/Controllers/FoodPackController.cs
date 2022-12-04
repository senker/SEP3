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
    
    public async Task<ActionResult> CreateFoodPack(FoodPackCreateDto foodPack)
    {
        return Ok(await _foodPackDao.CreateFoodPackAsync(foodPack));
    }
    
    [HttpGet("{id}")]
    public async Task<IActionResult> GetFoodPackById(int id)
    {
        var foodPack = await _foodPackDao.GetFoodPackByIdAsync(id);

        if (foodPack == null)
            return NotFound("Food pack not found");

        return Ok(foodPack);
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