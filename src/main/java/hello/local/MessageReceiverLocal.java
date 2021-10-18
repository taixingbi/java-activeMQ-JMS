package hello.local;
import hello.aws.JmsProviderAws;

import javax.jms.*;

public class MessageReceiverLocal implements MessageListener {
    private final String queueName= "MyQueue";

    private Connection con;

    public void startListener () throws JMSException {
        ConnectionFactory factory = JmsProviderLocal.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(queueName);
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(this);
    }

    @Override
    public void onMessage (Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {

                System.out.printf("Message Received: %s, Thread: %s%n",
                        tm.getText(),
                        Thread.currentThread().getName());
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void destroy () throws JMSException {
        con.close();
    }
}
