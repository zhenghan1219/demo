package com.zzh.exercise.context;

import com.zzh.exercise.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/23
 */
@Component
public class ServiceTest01 implements HandlerContext{

    @Override
    public void buildContext(Student student) {
        student.setName("张三");
        student.setSex(true);
        student.setAge(19);
    }

    @Override
    public List<?> result() {
        return null;
    }
}
