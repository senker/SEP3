using Domain.Models;
using Microsoft.Extensions.Caching.Memory;

namespace WastelessWASM;

public class SavedRestaurant
{
    private IMemoryCache _memoryCache;

    public SavedRestaurant(IMemoryCache memoryCache)
    {
        _memoryCache = memoryCache;
    }

    public async void SetSeller(SellerModel sellerModel)
    {
        _memoryCache.Set("seller", sellerModel, TimeSpan.FromMinutes(1));
    }

    public Task<SellerModel> GetSeller()
    {
        SellerModel output;

        output = _memoryCache.Get<SellerModel>("seller");
        return Task.FromResult(output);
    }
}