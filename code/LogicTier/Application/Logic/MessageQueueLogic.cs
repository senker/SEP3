using WastelessWASM;

namespace Application.Logic;

public class MessageQueueLogic
{
    public static void send(MessageQueue messageQueue)
    {
        messageQueue.listener();
    }
}