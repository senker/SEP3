using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class SellerController : ControllerBase
{
    private readonly ISellerDao _sellerLogic;
    
    public SellerController(ISellerDao sellerLogic)
    {
        _sellerLogic = sellerLogic;
    }

    [HttpPost]
    [Route("/seller")]
    public async Task<ActionResult> CreateSeller(SellerCreateDto seller)
    {
        /*try
        {
            SellerDto seller = await _sellerLogic.CreateSellerAsync(dto);
            Console.WriteLine("Created seller: ", seller);
            return Ok(seller);
            // return Created($"/users/{seller.User.Id}", seller);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }*/
        return Ok(await _sellerLogic.CreateSellerAsync(seller));
    }
    
    
    /*[HttpGet("{id}")]
    public async Task<IActionResult> GetGuestById(int id)
    {
        var guest = await _sellerLogic.(id);

        if (guest == null)
            return NotFound("Guest not found");

        return Ok(guest);
    }*/
    
    /*[HttpGet]
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
    }*/
}