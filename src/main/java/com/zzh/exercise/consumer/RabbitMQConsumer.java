package com.zzh.exercise.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Zhenghan
 * @Description: 消费者消费生产者的消息
 * @Date: Create by 2020/10/12
 */
//@Component
public class RabbitMQConsumer {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("rabbitmq_queue"))
    public void process(String message){
        System.out.println("consumer is :"+message);
    }
}
