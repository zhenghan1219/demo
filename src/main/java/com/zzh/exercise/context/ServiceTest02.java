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
public class ServiceTest02 implements HandlerContext{

    @Override
    public void buildContext(Student student) {
        student.setAge(19);
        student.setName("小芳");
        student.setSex(false);
    }

    @Override
    public List<?> result() {
        return null;
    }


}
