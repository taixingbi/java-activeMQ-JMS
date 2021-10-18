package hello.local;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;

public class JmsProviderLocal {
    static final String brokerURL = "tcp://127.0.0.1:61616";
    static final String USER_NAME= "admin";
    static final String PASSWORD= "admin";

    public static ConnectionFactory getConnectionFactory () {
//            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
//                    USER_NAME, PASSWORD, brokerURL);
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(brokerURL);

        return connectionFactory;
    }
}
