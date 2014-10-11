package com.jms.activemq.main;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jms.activemq.topic.Publisher;

public class PublishApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-publish.xml");

       //Sender sender = applicationContext.getBean(Sender.class);

//        System.out.println(((TextMessage) sender.sendTextMessage("alma")).getText());
//        System.out.println();
//        System.out.println(((TextMessage) sender.sendTextMessage("korte")).getText());
//        System.out.println();
//        System.out.println(((TextMessage) sender.sendTextMessage("banan")).getText());
//        System.out.println();
//        ConsoleJms consoleJms = new ConsoleJms();
//        consoleJms.sendTextMessage("keyki.queue", "console");
        Publisher publisher = applicationContext.getBean(Publisher.class);

        publisher.sendMessage("hey all1");
        publisher.sendMessage("hey all2");
        publisher.sendMessage("hey all3");
        publisher.sendMessage("hey all4");
        System.out.println("Press any key to exit.");
        System.in.read();
    }
}
