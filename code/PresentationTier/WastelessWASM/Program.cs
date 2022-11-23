using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using WastelessWASM;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(
    sp => 
        new HttpClient { 
            BaseAddress = new Uri("http://localhost:5283") 
        }
);


builder.Services.AddScoped<ISellerService, SellerHttpClient>();
builder.Services.AddScoped<ICustomerService, CustomerHttpClient>();

await builder.Build().RunAsync();