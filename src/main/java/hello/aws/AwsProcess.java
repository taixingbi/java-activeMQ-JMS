package hello.aws;

import javax.jms.JMSException;

public class AwsProcess {
    public static void JmsAws() throws JMSException {
        String xml=
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<text>" +
                "<para>hello jms</para>"+
                "</text>";

        MessageSenderAws.sendMessage(xml);
        MessageConsumerAws.receiveMessage();
    }
}
