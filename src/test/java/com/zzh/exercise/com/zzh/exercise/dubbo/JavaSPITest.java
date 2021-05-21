package com.zzh.exercise.com.zzh.exercise.dubbo;

import com.zzh.exercise.dubbo.spi.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/3/22
 */public class JavaSPITest {

     @Test
    public void test(){
         ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
         System.out.println("Java SPI");
         serviceLoader.forEach(Robot::sayHello);
     }
}
