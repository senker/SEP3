using System.Security.Claims;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components.Authorization;

namespace WastelessWASM.Auth;

public class CustomAuthProvider : AuthenticationStateProvider
{
    private readonly IAuthService authService;
    
    public CustomAuthProvider(IAuthService authService)
    {
        this.authService = authService;
        authService.OnAuthStateChanged += AuthStateChanged;
    }
    
    public override async Task<AuthenticationState> GetAuthenticationStateAsync()
    {
        ClaimsPrincipal principal = await authService.GetAuthAsync();
        
        return new AuthenticationState(principal);
    }
    
    private void AuthStateChanged(ClaimsPrincipal principal)
    {
        NotifyAuthenticationStateChanged(
            Task.FromResult(
                new AuthenticationState(principal)
            )
        );
    }
}