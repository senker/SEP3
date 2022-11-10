using Application.DaoInterfaces;
using Application.Logic;
using PersistenceDataAccess.DAOs;
using PersistenceDataAccess.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers();

// Grpc
builder.Services.AddSingleton<IGrpcService, GrpcService>();

// App services
builder.Services.AddScoped<ISellerDao, SellerDao>();
builder.Services.AddScoped<ISellerLogic, SellerLogic>();

// Swagger
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

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