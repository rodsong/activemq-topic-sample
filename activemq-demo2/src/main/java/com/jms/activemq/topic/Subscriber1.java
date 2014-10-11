package com.jms.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class Subscriber1 implements SessionAwareMessageListener<Message> {

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        if (message instanceof TextMessage) {
            System.out.println("Subscriber1 recieved message : " + ((TextMessage) message).getText());
        }
    }

}
