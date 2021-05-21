package com.zzh.exercise.dubbo.spi;

/**
 * @Author: Zhenghan
 * @Description: java SPI
 *  Service Provider Interface 是一种服务发现机制
 *  SPI的本质是将接口实现类的全限定名配置在文件中，并由服务加载器读取配置文件，加载实现类
 * @Date: Create by 2021/3/22
 */
public interface Robot {

    void sayHello();
}
