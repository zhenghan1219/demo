package com.zzh.exercise;

import com.zzh.exercise.producer.RabbitMQProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/10/12
 */
@SpringBootTest
public class RabbitmqTest {

    @Autowired
    RabbitMQProducer producer;

    @Test
    public void contextLoad(){
        producer.produce();
    }


}
