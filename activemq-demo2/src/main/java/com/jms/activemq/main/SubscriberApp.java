package com.jms.activemq.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubscriberApp {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-subscriber.xml");
        applicationContext.start();
       //Sender sender = applicationContext.getBean(Sender.class);

//        System.out.println(((TextMessage) sender.sendTextMessage("alma")).getText());
//        System.out.println();
//        System.out.println(((TextMessage) sender.sendTextMessage("korte")).getText());
//        System.out.println();
//        System.out.println(((TextMessage) sender.sendTextMessage("banan")).getText());
//        System.out.println();
//        Publisher publisher = applicationContext.getBean(Publisher.class);
//
//        publisher.sendMessage("hey all");
//        System.out.println();
//        publisher.sendMessage("hey all2");
//        ConsoleJms consoleJms = new ConsoleJms();
//        consoleJms.sendTextMessage("keyki.queue", "console");



        System.out.println("Press any key to exit.");
        System.in.read();

    }
}
