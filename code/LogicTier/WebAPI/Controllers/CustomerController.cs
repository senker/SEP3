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
    
    [HttpGet("{email}")]
    public async Task<IActionResult> GetCustomerByEmail(string email)
    {
        var guest = await _customerLogic.GetCustomerByEmailAsync(email);

        if (guest == null)
            return NotFound("Customer not found");

        return Ok(guest);
    }
    
    [HttpGet]
    [Route("/all-customers")]
    public async Task<IActionResult> GetAllCustomers()
    {
        var customers = await _customerLogic.GetAllCustomers();

        return Ok(customers);
    }
   
    [HttpDelete("{email}")]
    public async Task<IActionResult> DeleteCustomerByEmail(string email)
    {
        return Ok(await _customerLogic.DeleteCustomerByEmailAsync(email));
    }
}
