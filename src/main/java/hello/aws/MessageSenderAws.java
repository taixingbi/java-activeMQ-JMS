package hello.aws;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import javax.jms.*;

public class MessageSenderAws {
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
    sendMessage(String xml) throws JMSException {
        final Connection connection = createPooledConnectionFactory(connectionFactory)
                .createConnection();

        connection.start();
        // Create a session.
        final Session session = connection
                .createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a queue named "MyQueue".
        final Destination producerDestination = session
                .createQueue("MyQueue");

        // Create a producer from the session to the queue.
        final MessageProducer producer = session
                .createProducer(producerDestination);


        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        final TextMessage producerMessage = session
                .createTextMessage(xml);

        // Send the message.
        producer.send(producerMessage);
        System.out.println("Message sent: " + xml);

        // Clean up the producer.
        producer.close();
        session.close();
        connection.close();
    }
}