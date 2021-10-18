package hello.aws;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;

public class JmsProviderAws {
    private final static String WIRE_LEVEL_ENDPOINT
            = "ssl://b-11e561ed-aac0-41e8-ab8e-ef325e641487-1.mq.us-east-2.amazonaws.com:61617";
    private final static String ACTIVE_MQ_USERNAME = "admin";
    private final static String ACTIVE_MQ_PASSWORD = "Iwanttohavevacation1";

    public static ActiveMQConnectionFactory createActiveMQConnectionFactory() {
        // Create a connection factory.
        final ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(WIRE_LEVEL_ENDPOINT);

        // Pass the username and password.
        connectionFactory.setUserName(ACTIVE_MQ_USERNAME);
        connectionFactory.setPassword(ACTIVE_MQ_PASSWORD);
        return connectionFactory;
    }
}

