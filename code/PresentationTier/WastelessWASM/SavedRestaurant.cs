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

    public async Task<string> GetSeller()
    {
        return _memoryCache.Get<SellerModel>("seller").ToString();
    }
}