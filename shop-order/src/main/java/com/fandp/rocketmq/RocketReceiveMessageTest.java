package com.fandp.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @description: java 实现
 * @author: fandp
 * @create: 2020-05-16 14:19
 **/
public class RocketReceiveMessageTest {
        public static void main(String[] args) throws MQClientException {
            //1. 创建消费者，并且为其指定消费者组名
            DefaultMQPushConsumer consumer= new DefaultMQPushConsumer("myconsumer-group");
            //2. 为消费者设置NameServer的地址
            consumer.setNamesrvAddr("localhost:9876");
            //3. 指定消费者要订阅的主题和标签
            consumer.subscribe("myTopic","*");
            //4. 设置一个回调函数，并在函数中编写接收到消息之后的处理方法
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                //处理获取到的消息
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    //消费逻辑
                    System.out.println("MEssage=>"+list);
                    //返回消费成功状态
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            //5. 启动消费者
            consumer.start();
            System.out.println("启动消费者成功");


        }
    }
