package com.jms.activemq.queue;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class Reciever implements SessionAwareMessageListener<Message> {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        if (message instanceof TextMessage) {
            System.out.println("Recieved message : " + ((TextMessage) message).getText());
            if (message.getJMSReplyTo() != null)
                sendReply(message.getJMSReplyTo(), ((TextMessage) message).getText() + " reply");
        }
    }

    private void sendReply(final Destination replyTo, final String message) {
        System.out.println("Sending reply: " + message + " to: " + replyTo.toString());
        jmsTemplate.send(replyTo, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

}
