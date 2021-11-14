package hello.local;

import javax.jms.JMSException;

public class LocalProcess {
    public static void JmsLocal() throws JMSException, InterruptedException {
      final MessageSenderLocal messageSenderLocal = new MessageSenderLocal();
      final MessageConsumerLocal messageConsumerLocal = new MessageConsumerLocal();
      messageConsumerLocal.startListener();

      String xml=
          "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
              "<text>" +
              "<para>hello jms!</para>"+
              "</text>";

      for (int i = 0; i < 1; i++) {
        messageSenderLocal.sendMessage( xml );
          Thread.sleep(300);
      }
      messageSenderLocal.destroy();
      messageConsumerLocal.destroy();
    }
}
