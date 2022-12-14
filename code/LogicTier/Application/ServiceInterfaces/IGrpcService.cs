using Grpc.Net.Client;

namespace Application.ServiceInterfaces;

public interface IGrpcService
{
    GrpcChannel GetChannel();
}