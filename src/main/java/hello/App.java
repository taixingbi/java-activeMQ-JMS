package hello;

import hello.aws.AwsProcess;
import hello.local.LocalProcess;
import hello.simple.SimpleProcess;

import javax.jms.JMSException;

public class App {
    public static void main(String[] args) throws InterruptedException, JMSException {
        System.out.println("----------app start----------");
        AwsProcess.JmsAws();
//        LocalProcess.JmsLocal();
//        SimpleProcess.jmsSimple();
        System.out.println("----------app end----------");
    }







}
