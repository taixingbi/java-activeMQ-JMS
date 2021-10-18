
## amazon mg 
### broker
```
https://us-east-2.console.aws.amazon.com/amazon-mq/home?region=us-east-2#/brokers/details?id=b-11e561ed-aac0-41e8-ab8e-ef325e641487
```
### console login
```
https://b-11e561ed-aac0-41e8-ab8e-ef325e641487-1.mq.us-east-2.amazonaws.com:8162/admin/browse.jsp?JMSDestination=MyQueue
```

## local activemq server
### broker 
```
tcp://127.0.0.1:61616"
```

### install activemq on mac
```
brew install apache-activemq
brew services start activemq
```

### console login
```
http://127.0.0.1:8161/admin/
user: admin
password: admin
```

### reference
```
https://activemq.apache.org/hello-world
https://www.logicbig.com/tutorials/java-ee-tutorial/jms/jms-helloworld.html
https://docs.aws.amazon.com/amazon-mq/latest/developer-guide/amazon-mq-working-java-example.html
```
