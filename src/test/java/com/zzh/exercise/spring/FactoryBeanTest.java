package com.zzh.exercise.spring;

import com.zzh.exercise.entity.Student;
import org.junit.Test;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/3/24
 */
public class FactoryBeanTest {


    @Test
    public void test() throws Exception {
        FactoryBeanDemo demo = new FactoryBeanDemo();
        Student student = demo.getObject();
        student.setGarde("12");
        Student student1 = demo.getObject();
        System.out.println(student1.getGarde());
    }

    @Test
    public void test_singleton() throws Exception {
        FactoryBeanDemo demo = new FactoryBeanDemo();
        Student student = demo.getObject();
        System.out.println(student.getGarde());
    }
}
