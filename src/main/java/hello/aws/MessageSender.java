package hello.aws;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import javax.jms.*;

public class MessageSender {
    final static ActiveMQConnectionFactory connectionFactory =
            JmsProviderAws.createActiveMQConnectionFactory();

    private static PooledConnectionFactory
    createPooledConnectionFactory(ActiveMQConnectionFactory connectionFactory) {
        final PooledConnectionFactory pooledConnectionFactory =
                new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(connectionFactory);
        pooledConnectionFactory.setMaxConnections(10);
        return pooledConnectionFactory;
    }

    public static void
    sendMessage() throws JMSException {
        final Connection producerConnection = createPooledConnectionFactory(connectionFactory)
                .createConnection();

        producerConnection.start();

        // Create a session.
        final Session producerSession = producerConnection
                .createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a queue named "MyQueue".
        final Destination producerDestination = producerSession
                .createQueue("MyQueue");

        // Create a producer from the session to the queue.
        final MessageProducer producer = producerSession
                .createProducer(producerDestination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // Create a message.
//        final String text = "Hello amazon MQ!!!";
        String xml=
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<text>" +
                        "<para>hello jms</para>"+
                        "</text>";

        final TextMessage producerMessage = producerSession
                .createTextMessage(xml);

        // Send the message.
        producer.send(producerMessage);
        System.out.println("Message sent: " + xml);

        // Clean up the producer.
        producer.close();
        producerSession.close();
        producerConnection.close();
    }
}