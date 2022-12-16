using System.Security.Claims;
using Domain.DTOs;

namespace HttpClients.ClientInterfaces;
// reference https://troelsmortensen.github.io/CodeLabs/Tutorials/BlazorWasmJwtAuth/Page.html
public interface IAuthService
{
    public Task LoginAsync(string username, string password);
    public Task LogoutAsync();
    public Task<ClaimsPrincipal> GetAuthAsync();

    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
}