using System.Transactions;
using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;
using Google.Protobuf;
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
    
    
    [HttpGet("{cvr}")]
    public async Task<IActionResult> GetSellerByCvr(int cvr)
    {
        var guest = await _sellerLogic.GetSellerByCvrAsync(cvr);

        if (guest == null)
            return NotFound("Seller not found");

        return Ok(guest);
    }

    [HttpGet]
    [Route("/all-sellers")]
    public async Task<IActionResult> GetAllSellers()
    {
        var sellers = await _sellerLogic.GetAllSellers();

        return Ok(sellers);
    }
    
    
    [HttpDelete("{cvr}")]
    public async Task<IActionResult> DeleteSellerByCvr(int cvr)
    {
        return Ok(await _sellerLogic.DeleteSellerByCvrAsync(cvr));
    }
    
}