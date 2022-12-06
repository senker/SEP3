using Domain.Auth;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using Microsoft.AspNetCore.Http;
using WastelessWASM;
using WastelessWASM.Auth;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(
    sp => 
        new HttpClient { 
            BaseAddress = new Uri("https://localhost:7133") 
        }
);


builder.Services.AddScoped<ISellerService, SellerHttpClient>();
builder.Services.AddScoped<ICustomerService, CustomerHttpClient>();
builder.Services.AddScoped<IAuthService, JwtAuthService>();
builder.Services.AddScoped<AuthenticationStateProvider, CustomAuthProvider>();
builder.Services.AddScoped<IFoodPackService, FoodPackHttpClient>();
builder.Services.AddTransient<SavedRestaurant>();
builder.Services.AddMemoryCache();

AuthorizationPolicies.AddPolicies(builder.Services);

await builder.Build().RunAsync();