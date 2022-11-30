using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Application.DaoInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using JwtRegisteredClaimNames = Microsoft.IdentityModel.JsonWebTokens.JwtRegisteredClaimNames;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class AuthController : ControllerBase
{
    private readonly IConfiguration config;
    private readonly ICustomerDao authCustomerService;

    public AuthController(IConfiguration config, ICustomerDao authCustomerService)
    {
        this.config = config;
        this.authCustomerService = authCustomerService;
    }
    
    private List<Claim> GenerateClaims(CustomerDto user)
    {
        var claims = new[]
        {
            new Claim(JwtRegisteredClaimNames.Sub, config["Jwt:Subject"]),
            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
            new Claim(JwtRegisteredClaimNames.Iat, DateTime.UtcNow.ToString()),
            new Claim(ClaimTypes.Name, user.User.Email),
            new Claim(ClaimTypes.Role, "customer"),
            new Claim("DisplayFirstName", user.User.FirstName),
            new Claim("DisplayLastName", user.User.LastName),
            new Claim("AddressCity", user.User.Address.City),
            new Claim("AddressStreet", user.User.Address.Streetname),
            new Claim("AddressPostcode", user.User.Address.Postcode.ToString()),
            new Claim("Email", user.User.Email),
            new Claim("PhoneNumber", user.User.PhoneNumber.ToString()),
            new Claim("Preferences", user.Preference),
            new Claim("SecurityLevel", "7")
        };
        return claims.ToList();
    }
    
    private string GenerateJwt(CustomerDto user)
    {
        List<Claim> claims = GenerateClaims(user);
    
        SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(config["Jwt:Key"]));
        SigningCredentials signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha512);
    
        JwtHeader header = new JwtHeader(signIn);
    
        JwtPayload payload = new JwtPayload(
            config["Jwt:Issuer"],
            config["Jwt:Audience"],
            claims, 
            null,
            DateTime.UtcNow.AddMinutes(60));
    
        JwtSecurityToken token = new JwtSecurityToken(header, payload);
    
        string serializedToken = new JwtSecurityTokenHandler().WriteToken(token);
        return serializedToken;
    }
    
    [HttpPost, Route("login")]
    public async Task<ActionResult> Login([FromBody] UserLoginDto userLoginDto)
    {
        try
        {
            CustomerDto user = await authCustomerService.ValidateCustomer(userLoginDto.Username, userLoginDto.Password);
            string token = GenerateJwt(user);
    
            return Ok(token);
        }
        catch (Exception e)
        {
            return BadRequest(e.Message);
        }
    }
}