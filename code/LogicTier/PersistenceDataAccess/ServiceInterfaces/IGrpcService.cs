using Grpc.Net.Client;

namespace PersistenceDataAccess.ServiceInterfaces;

public interface IGrpcService
{
    GrpcChannel GetChannel();
}