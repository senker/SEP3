using Grpc.Net.Client;

namespace PersistenceDataAccess.Services;

public interface IGrpcService
{
    GrpcChannel GetChannel();
}