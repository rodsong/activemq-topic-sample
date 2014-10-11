package com.jms.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

import java.util.Date;

public class Subscriber2 implements SessionAwareMessageListener<Message> {

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        if (message instanceof TextMessage) {
            if("hey all2".equals(((TextMessage) message).getText())){
                System.out.println("rollback :"+new Date().getSeconds());
                session.recover();
                return;
            }
            System.out.println("Subscriber2 recieved message : " + ((TextMessage) message).getText());
            message.acknowledge();
        }
    }

}
