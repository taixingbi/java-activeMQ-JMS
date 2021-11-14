package hello.local;

import javax.jms.*;


public class MessageSenderLocal {
    private final String queueName= "MyQueue";

    private final MessageProducer producer;
    private final Session session;
    private final Connection connection;

    public MessageSenderLocal() throws JMSException {
        ConnectionFactory factory = JmsProviderLocal.getConnectionFactory();
        this.connection = factory.createConnection();
        connection.start();

        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(queueName);
        this.producer = session.createProducer(queue);
    }

    public void sendMessage (String message) throws JMSException {
        System.out.printf("Sending message: %s, Thread:%s%n",
                message,
                Thread.currentThread().getName());
        TextMessage textMessage = session.createTextMessage(message);
        producer.send(textMessage);
    }

    public void destroy () throws JMSException {
        connection.close();
    }
}