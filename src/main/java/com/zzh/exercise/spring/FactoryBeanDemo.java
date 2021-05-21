package com.zzh.exercise.spring;

import com.zzh.exercise.entity.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/3/24
 */
public class FactoryBeanDemo implements FactoryBean<Student> {
    //该方法返回该FactoryBean“生产”的对象
    //返回你想要的类
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    /**
     *  返回的是当前对象的类型，可以用来判断这个对象是否为该对象
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * 返回的对象是否为单例，如果是单例，则Spring全局只保持一个实例对象；
     * false则每次获取的时候都将获取一个新的实例对象
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
