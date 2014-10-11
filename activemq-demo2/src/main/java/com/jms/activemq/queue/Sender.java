package com.jms.activemq.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Component;

//@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue defaultDestination;

    public Message sendTextMessage(String message) {
        return sendTextMessage(defaultDestination, message);
    }

    public Message sendTextMessage(final Queue destination, final String message) {

        assert (destination != null);

        return jmsTemplate.execute(new SessionCallback<Message>() {
            @Override
            public Message doInJms(Session session) throws JMSException {
                MessageProducer producer = session.createProducer(destination);
                TextMessage textMessage = session.createTextMessage(message);

                TemporaryQueue temporaryQueue = session.createTemporaryQueue();
                textMessage.setJMSReplyTo(temporaryQueue);

                System.out.println("Sending message: " + message + " to: " + destination.toString() + " and waiting for reply to queue: "
                        + temporaryQueue);
                producer.send(textMessage);
                return session.createConsumer(temporaryQueue).receive();
            }
        }, true);
    }

}