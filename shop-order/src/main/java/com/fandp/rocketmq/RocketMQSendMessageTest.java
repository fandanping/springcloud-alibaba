package com.fandp.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;


/**
 * @description: java 实现
 * @author: fandp
 * @create: 2020-05-16 14:03
 **/
public class RocketMQSendMessageTest {
    //发送消息
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //创建消息生产者，并且设置生产组名
        DefaultMQProducer producer = new DefaultMQProducer("test1");
        //为生产者设置NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动生产者
        producer.start();
        //构建消息对象,主要是设置消息的主题，标签 内容
        Message msg= new Message("myTopic","myTag",("RocketMQ Message").getBytes());
        //发送消息,第二个参数代表超时时间
        SendResult result = producer.send(msg,10000);
        System.out.println(result);
        //关闭生产者
        producer.shutdown();
    }
}
