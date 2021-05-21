package com.zzh.exercise.context;

import com.zzh.exercise.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/23
 */
@Component
public class ServiceImplTest{

    @Autowired
    private ServiceTest01 serviceTest01;

    @Autowired
    private ServiceTest02 serviceTest02;

    public static void demo(String[] args) {
        Student student = new Student();


    }
}
