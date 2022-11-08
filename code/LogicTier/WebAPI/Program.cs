using Application.DaoInterfaces;
using Application.Logic;
using PersistenceDataAccess;
using PersistenceDataAccess.DAOs;
using PersistenceDataAccess.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// gRPC (channel) service must be added before other gRPC services
builder.Services.AddSingleton<IGrpcService, GrpcService>();
builder.Services.AddScoped<ISellerDao, SellerDao>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();