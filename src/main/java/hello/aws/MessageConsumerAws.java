package hello.aws;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;

import javax.jms.*;

public class MessageConsumerAws {
    final static ActiveMQConnectionFactory connectionFactory =
            JmsProviderAws.createActiveMQConnectionFactory();

    public static void receiveMessage() throws JMSException {
        final Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a session.
        final Session session = connection
                .createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a queue named "MyQueue".
        final Destination consumerDestination = session
                .createQueue("MyQueue");

        // Create a message consumer from the session to the queue.
        final javax.jms.MessageConsumer consumer = session
                .createConsumer(consumerDestination);

        // Begin to wait for messages.
        final Message consumerMessage = consumer.receive(1000);

        // Receive the message when it arrives.
        final TextMessage consumerTextMessage = (TextMessage) consumerMessage;
        System.out.println("Message received: " + consumerTextMessage.getText());

        // Clean up the consumer.
        consumer.close();
        session.close();
        connection.close();
    }
}