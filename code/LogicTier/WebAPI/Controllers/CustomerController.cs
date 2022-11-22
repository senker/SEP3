using Application.DaoInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class CustomerController : ControllerBase
{
    private readonly ICustomerDao _customerLogic;

    public CustomerController(ICustomerDao customerLogic)
    {
        _customerLogic = customerLogic;
    }

    [HttpPost]
    [Route("/customer")]
    public async Task<ActionResult> CreateCustomer(CustomerCreateDto customer)
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
        return Ok(await _customerLogic.CreateCustomerAsync(customer));
    }


    [HttpGet("{email}")]
    public async Task<IActionResult> GetCustomerByEmail(string email)
    {
        var guest = await _customerLogic.GetCustomerByEmailAsync(email);

        if (guest == null)
            return NotFound("Customer not found");

        return Ok(guest);
    }

    [HttpDelete("{email}")]
    public async Task<IActionResult> DeleteCustomerByEmail(string email)
    {
        return Ok(await _customerLogic.DeleteCustomerByEmailAsync(email));
    }
}
