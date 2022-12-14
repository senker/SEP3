using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using PersistenceDataAccess.ServiceInterfaces;
using JwtRegisteredClaimNames = Microsoft.IdentityModel.JsonWebTokens.JwtRegisteredClaimNames;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class AuthController : ControllerBase
{
    private readonly IConfiguration _config;
    private readonly IAuthLogic _authLogic;

    public AuthController(IConfiguration config, IAuthLogic authLogic)
    {
        _config = config;                                                                              
        _authLogic = authLogic;
    }
    
    private List<Claim> GenerateClaimsCustomer(CustomerDto user)
    {
        var claims = new[]
        {
            new Claim(JwtRegisteredClaimNames.Sub, _config["Jwt:Subject"]),
            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
            new Claim(JwtRegisteredClaimNames.Iat, DateTime.UtcNow.ToString()),
            new Claim(ClaimTypes.Name, user.User.Email),
            new Claim(ClaimTypes.Role, "customer"),
            new Claim("DisplayFirstName", user.User.FirstName),
            new Claim(ClaimTypes.Sid, user.User.Email),
            new Claim("SecurityLevel", "3")
        };
        return claims.ToList();
    }
    
    private List<Claim> GenerateClaimsSeller(SellerDto user)
    {
        var claims = new[]
        {
            new Claim(JwtRegisteredClaimNames.Sub, _config["Jwt:Subject"]),
            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
            new Claim(JwtRegisteredClaimNames.Iat, DateTime.UtcNow.ToString()),
            new Claim(ClaimTypes.Name, user.User.Email),
            new Claim(ClaimTypes.Role, "seller"),
            new Claim("DisplayFirstName", user.User.FirstName),
            new Claim(ClaimTypes.Sid, user.Cvr.ToString()),
            new Claim("SecurityLevel", "5")
        };
        return claims.ToList();
    }
    
    private string GenerateJwtCustomer(CustomerDto user)
    {
        List<Claim> claims = GenerateClaimsCustomer(user);
    
        SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_config["Jwt:Key"]));
        SigningCredentials signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha512);
    
        JwtHeader header = new JwtHeader(signIn);
    
        JwtPayload payload = new JwtPayload(
            _config["Jwt:Issuer"],
            _config["Jwt:Audience"],
            claims, 
            null,
            DateTime.UtcNow.AddMinutes(60));
    
        JwtSecurityToken token = new JwtSecurityToken(header, payload);
    
        string serializedToken = new JwtSecurityTokenHandler().WriteToken(token);
        return serializedToken;
    }
    
    private string GenerateJwtSeller(SellerDto user)
    {
        List<Claim> claims = GenerateClaimsSeller(user);
    
        SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_config["Jwt:Key"]));
        SigningCredentials signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha512);
    
        JwtHeader header = new JwtHeader(signIn);
    
        JwtPayload payload = new JwtPayload(
            _config["Jwt:Issuer"],
            _config["Jwt:Audience"],
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
            var customer = await _authLogic.ValidateCustomer(userLoginDto.Username, userLoginDto.Password);
            if (customer != null)
            {
                string token = GenerateJwtCustomer(customer);
                return Ok(token);
            }
            
            var seller = await _authLogic.ValidateSeller(userLoginDto.Username, userLoginDto.Password);
            if (seller != null)
            {
                string token = GenerateJwtSeller(seller);
                return Ok(token);
            }
    
            return NotFound("User or password is incorrect");
        }
        catch (Exception e)
        {
            return BadRequest(e.Message);
        }
    }
}