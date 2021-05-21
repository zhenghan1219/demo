package com.zzh.exercise.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/3/22
 */
@SPI
public class OptimusPrime implements Robot{

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}
