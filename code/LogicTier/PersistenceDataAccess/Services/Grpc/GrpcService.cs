using Grpc.Net.Client;

namespace PersistenceDataAccess.Services;

public class GrpcService : IGrpcService
{
    private readonly GrpcChannel _channel;

    public GrpcService()
    {
        _channel = GrpcChannel.ForAddress("http://localhost:6565");
    }

    public GrpcChannel GetChannel()
    {
        return _channel;
    }
}