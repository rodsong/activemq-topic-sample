package com.jms.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Topic defaultDestination;

    public void sendMessage(String message) {
        sendMessage(defaultDestination, message);
    }

    public void sendMessage(Topic destination, final String message) {

        assert (destination != null);

        System.out.println("Sending message: " + message + " to: " + destination.toString());
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });

    }

}
