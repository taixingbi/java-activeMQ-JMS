package hello.simple;

public class SimpleProcess {
    public static void jmsSimple() throws InterruptedException {
      JmsProducerSimple jmsProducerSimple = new JmsProducerSimple();
      JmsConsumerSimple jmsConsumerSimple = new JmsConsumerSimple();
      jmsProducerSimple.MessageSender();
      Thread.sleep(1000);
      jmsConsumerSimple.MessageReceiver();
    }
}
