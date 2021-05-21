package com.zzh.exercise.dubbo;

//import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.zzh.exercise.dubbo.spi.Robot;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/2/22
 */
public class SerializableTest {

    public static void main(String[] args) {
        ByteOutputStream os = new ByteOutputStream();
        //Hessian2的序列化输出
        //Hessian2Output ho = new Hessian2Output(os);
        Map<String,Object> map = new HashMap<>();
        ServiceLoader serviceLoader = ServiceLoader.load(Robot.class);
        //serviceLoader.forEach(Robot::sayHello);

    }
}
