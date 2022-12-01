using System.Globalization;
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
        _memoryCache.Set("user_id", sellerModel.User.Id, TimeSpan.FromMinutes(1));
        _memoryCache.Set("first_name", sellerModel.User.FirstName, TimeSpan.FromMinutes(1));
        _memoryCache.Set("last_name", sellerModel.User.LastName, TimeSpan.FromMinutes(1));
        _memoryCache.Set("city", sellerModel.User.Address.City, TimeSpan.FromMinutes(1));
        _memoryCache.Set("post_code", sellerModel.User.Address.Postcode, TimeSpan.FromMinutes(1));
        _memoryCache.Set("street_name", sellerModel.User.Address.Streetname, TimeSpan.FromMinutes(1));
        _memoryCache.Set("cvr", sellerModel.Cvr, TimeSpan.FromMinutes(1));
        _memoryCache.Set("company_name", sellerModel.CompanyName, TimeSpan.FromMinutes(1));
        _memoryCache.Set("description", sellerModel.Description, TimeSpan.FromMinutes(1));
        _memoryCache.Set("type", sellerModel.Type, TimeSpan.FromMinutes(1));
        _memoryCache.Set("website", sellerModel.Website, TimeSpan.FromMinutes(1));
        _memoryCache.Set("rating", sellerModel.Rating, TimeSpan.FromMinutes(1));
    }

    public List<string> GetSeller()
    {
        List<string> sellerList = new List<string>();
        sellerList.Add(_memoryCache.Get<int>("user_id").ToString());
        sellerList.Add(_memoryCache.Get<string>("first_name"));
        sellerList.Add(_memoryCache.Get<string>("last_name"));
        sellerList.Add(_memoryCache.Get<string>("city"));
        sellerList.Add(_memoryCache.Get<int>("post_code").ToString());
        sellerList.Add(_memoryCache.Get<string>("street_name"));
            sellerList.Add(_memoryCache.Get<int>("cvr").ToString());
            sellerList.Add(_memoryCache.Get<string>("company_name"));
            sellerList.Add(_memoryCache.Get<string>("description"));
            sellerList.Add(_memoryCache.Get<string>("type"));
            sellerList.Add(_memoryCache.Get<string>("website"));
            sellerList.Add(string.Format("{0:N2}", _memoryCache.Get<float>("rating")));
        //return _memoryCache.Get<SellerModel>("seller").ToString();
        return sellerList;
    }
}