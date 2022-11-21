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
        return Ok(await _customerLogic.CreateCustomerAsync(customer));
    }
    
    [HttpGet("{id}")]
    public async Task<IActionResult> GetCustomerById(int id)
    {
        var guest = await _customerLogic.GetCustomerByIdAsync(id);

        if (guest == null)
            return NotFound("Customer not found");

        return Ok(guest);
    }
    
    [HttpDelete("{cvr}")]
    public async Task<IActionResult> DeleteCustomerById(int id)
    {
        return Ok(await _customerLogic.DeleteCustomerByIdAsync(id));
    }
}