package hello.demo;

import javax.jms.*;


public class MessageSender {
    private final String queueName= "example.queue";

    private final MessageProducer producer;
    private final Session session;
    private final Connection con;

    public MessageSender () throws JMSException {
        ConnectionFactory factory = JmsProvider.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        this.session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
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
        con.close();
    }
}