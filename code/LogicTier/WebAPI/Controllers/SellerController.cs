using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class SellerController : ControllerBase
{
    private readonly ISellerLogic sellerLogic;
    
    public SellerController(ISellerLogic sellerLogic)
    {
        this.sellerLogic = sellerLogic;
    }
    
    [HttpPost]
    public async Task<ActionResult<SellerModel>> CreateAsync(SellerDto dto)
    {
        try
        {
            SellerDto seller = await sellerLogic.CreateSellerAsync(dto);
            return Created($"/users/{seller.User.Id}", seller);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpGet]
    public async Task<ActionResult<IEnumerable<SellerModel>>> GetAsync([FromQuery] string? id)
    {
        try
        {
            SearchSellerParametersDto parameters = new(id);
            IEnumerable<SellerDto> sellers = await sellerLogic.GetAsync(parameters);
            return Ok(sellers);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}