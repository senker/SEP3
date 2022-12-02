using Application.DaoInterfaces;
using PersistenceDataAccess;
//using Application.Logic;
using PersistenceDataAccess.DAOs;
using PersistenceDataAccess.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers();

// Grpc
builder.Services.AddSingleton<IGrpcService, GrpcService>();


builder.Services.AddDistributedMemoryCache();


builder.Services.AddSession(options =>
{
    options.IdleTimeout = TimeSpan.FromSeconds(10);
    options.Cookie.HttpOnly = true;
    options.Cookie.IsEssential = true;
});

// App services
builder.Services.AddScoped<ISellerDao, SellerDao>();
builder.Services.AddScoped<ICustomerDao, CustomerDao>();
//builder.Services.AddScoped<ISellerLogic, SellerLogic>();

// Swagger
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

app.UseCors(x => x
    .AllowAnyMethod()
    .AllowAnyHeader()
    .SetIsOriginAllowed(origin => true) // allow any origin
    .AllowCredentials());

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.UseSession();

app.Run();