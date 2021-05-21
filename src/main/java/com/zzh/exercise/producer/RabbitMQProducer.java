package com.zzh.exercise.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: Zhenghan
 * @Description: 生产者主要用来生产消息发送
 * @Date: Create by 2020/10/12
 */
//@Component
public class RabbitMQProducer {

    /** 消息发送的关键类 */
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void produce(){
        String message = new Date()+"Beijing时间";
        System.out.println("Producer is :"+message);
        //convertAndSend 方法可以指定消息发送的交换器，路由健，消息内容等
        rabbitTemplate.convertAndSend("rabbitmq_queue",message);
        System.out.println("producer 发送成功");
    }
}
