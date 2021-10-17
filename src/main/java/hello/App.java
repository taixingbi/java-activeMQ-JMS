package hello;

import hello.demo.MessageReceiver;
import hello.demo.MessageSender;

import javax.jms.JMSException;

public class App {
    public static void main(String[] args) throws InterruptedException, JMSException {
        System.out.println("----------app start----------");
        //simpleJms();
        demoJms();
        System.out.println("----------app end----------");
    }

    static void demoJms() throws JMSException, InterruptedException {
        final MessageSender sender = new MessageSender();

        final MessageReceiver receiver = new MessageReceiver();
        receiver.startListener();

        String xml=
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<text>" +
                    "<para>hello jms</para>"+
                "</text>";

        for (int i = 0; i < 1; i++) {
            sender.sendMessage( xml );
            Thread.sleep(300);
        }

        sender.destroy();
        receiver.destroy();
    }

    static void simpleJms() throws InterruptedException {
        JmsProducer jmsProducer = new JmsProducer();
        JmsConsumer jmsConsumer = new JmsConsumer();
        jmsProducer.MessageSender();
        Thread.sleep(1000);
        jmsConsumer.MessageReceiver();
    }

}
