/*using Application.DaoInterfaces;
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
    
    public async Task<SellerDto> CreateSellerAsync(SellerCreateDto dto)
    {
        SellerDto? existing = await sellerDao.GetByIdAsync(dto.User.);
        
        if (existing != null)
            throw new Exception("User id already in use!");

        ValidateData(dto);
        SellerCreateModel toCreate = new SellerCreateModel()
        {
            User = dto.User,
            CompanyName = dto.CompanyName,
            Cvr = dto.Cvr,
            Description = dto.Description,
            Rating = dto.Rating,
            Type = dto.Type,
            Website = dto.Website
        };
    
        SellerDto created = await sellerDao.CreateSellerAsync(dto);
    
        return created;
    }
    
    private static void ValidateData(SellerCreateDto sellerToCreate)
    {
        string firstName = sellerToCreate.User.FirstName;

        if (firstName.Length < 3)
            throw new Exception("Username must be at least 3 characters!");

        if (firstName.Length > 15)
            throw new Exception("Username must be less than 16 characters!");
    }

    /*public Task<IEnumerable<SellerDto>> GetAsync(SearchSellerParametersDto searchParameters)
    {
        return sellerDao.GetAsync(searchParameters);
    }#1#
    
    /*public Task<SellerDto> GetSellerByIdAsync(int id)
    {
        return sellerDao.GetByIdAsync(id);
    }#1#
}*/