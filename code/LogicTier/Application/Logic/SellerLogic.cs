using Application.DaoInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class SellerLogic : ISellerLogic
{

    private readonly ISellerDao sellerDao;
    
    public SellerLogic(ISellerDao sellerDao)
    {
        this.sellerDao = sellerDao;
    }
    
    public async Task<SellerModel> CreateSellerAsync(SellerDto dto)
    {
        SellerModel? existing = await sellerDao.GetByEmailAsync(dto.User.Email);
        if (existing != null)
            throw new Exception("Email address is in use!");

        ValidateData(dto);
        SellerModel toCreate = new SellerModel()
        {
            User = dto.User,
            CompanyName = dto.CompanyName,
            Cvr = dto.Cvr,
            Description = dto.Description,
            Rating = dto.Rating,
            Type = dto.Type,
            Website = dto.Website
        };
    
        SellerModel created = await sellerDao.CreateSellerAsync(toCreate);
    
        return created;
    }
    
    private static void ValidateData(SellerDto sellerToCreate)
    {
        string firstName = sellerToCreate.User.FirstName;

        if (firstName.Length < 3)
            throw new Exception("Username must be at least 3 characters!");

        if (firstName.Length > 15)
            throw new Exception("Username must be less than 16 characters!");
    }

    public Task<IEnumerable<SellerModel>> GetAsync(SearchSellerParametersDto searchParameters)
    {
        return sellerDao.GetAsync(searchParameters);
    }
}