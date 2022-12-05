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
    private static string? _imageUrl;

    public SellerController(ISellerDao sellerLogic)
    {
        _sellerLogic = sellerLogic;
    }

    [NonAction]
    public string GetImage()
    {
        if(_imageUrl == "")
        {
            //Console.WriteLine(_imageUrl);
            Thread.Sleep(1000);
        }
        //Console.WriteLine(_imageUrl);
        return _imageUrl!;
    }


    [HttpPost]
    [Route("/image")]
    public Task PostImage([FromBody] string imageInController)
    {
        _imageUrl = imageInController;
        return Task.CompletedTask;
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
        if(_imageUrl != null)
        {
                seller.Image = _imageUrl;
        }else {seller.Image = "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cmVzdGF1cmFudHxlbnwwfHwwfHw%3D&w=1000&q=80";}
            
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

        //Console.WriteLine(sellers[0].Image);

        return Ok(sellers);
    }
    
    
    [HttpDelete("{cvr}")]
    public async Task<IActionResult> DeleteSellerByCvr(int cvr)
    {
        return Ok(await _sellerLogic.DeleteSellerByCvrAsync(cvr));
    }
    
}