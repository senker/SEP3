using System.Text;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

namespace WastelessWASM;

public class MessageQueue
{

    public void listener()
    {
        String QUEUE_NAME = "subscribe.queue";
            ConnectionFactory factory = new ConnectionFactory();
            factory.UserName = "guest";
            factory.Password = "guest";
            factory.VirtualHost = "/";
            factory.HostName = "localhost";
            factory.Port = 5672;

            IConnection conn = factory.CreateConnection();
            using var channel = conn.CreateModel();
            channel.QueueDeclare(QUEUE_NAME, false, false, false, null);
            // channel.ExchangeDeclare("subscribe.queue.channel", "fanout");

            try{
                var consumer = new EventingBasicConsumer(channel);
                consumer.Received += (ch, ea) =>
                {
                    var body = ea.Body.ToArray();
                    var message = Encoding.UTF8.GetString(body);
                    //channel.BasicAck(ea.DeliveryTag, false);
                    Console.Write(message);
                };

                string consumerTag = channel.BasicConsume(QUEUE_NAME, false, consumer);
                System.Threading.Thread.Sleep(2000);
            } catch(Exception e)
            {
                Console.Write("Error is: " + e.Message);
            }
        }
    }
