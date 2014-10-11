
1.本例是研究activemq topic的应用

  持久化消息，每个订阅者拿到的是发送消息的copy，每个copy都会记录发送状态

  activemq-demo1 中有topic发送者，1个订阅者
  activemq-demo2 中有一个订阅者

  订阅者之间互不影响消息状态。

  	<bean id="jmsContainer2"
  		class="org.springframework.jms.listener.DefaultMessageListenerContainer">
  		<property name="connectionFactory" ref="topicListenConnectionFactory" />
  		<property name="destination" ref="keykiTopic" />
          <!---这里是设置接收客户端的ID，在持久化时，但这个客户端不在线时，
          消息就存在数据库里，知道被这个ID的客户端消费掉-->
          <property name="clientId" value="clientId_002"/>
          <property name="messageListener" ref="messageSubscriber2" />
          <property name="subscriptionDurable" value="true"/>
          <property name="sessionAcknowledgeMode" value="2"/>
      </bean>

   subscriptionDurable 表示持久化消息。
   sessionAcknowledgeMode 表示消费者自己确认消息接受。
   要注意消息产生者也要是持久化的，才能保证数据的安全性。

2. running
  step one，activemq-demo2/ PublishApp main
  step two，activemq-demo1/ SubscriberApp main


3. todo
   . activemq 集群应用