package com;

import com.zzh.exercise.dubbo.spi.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/3/22
 */
public class DubboSPITest {

    @Test
    public void test(){
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
