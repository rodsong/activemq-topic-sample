package com.jms.activemq.main;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class ConsoleJms {

    private ConnectionFactory cf;
    private Connection connection;
    private Session session;

    public ConsoleJms() throws JMSException {
        cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = (Connection) cf.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public void sendTextMessage(String destination, String message) throws JMSException {
        Destination destination2 = new ActiveMQQueue(destination);
        MessageProducer producer = session.createProducer(destination2);
        TextMessage textMessage = session.createTextMessage(message);
        System.out.println("Sending message: " + message + " to: " + destination.toString());
        producer.send(textMessage);
    }
}
