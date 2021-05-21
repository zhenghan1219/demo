package com.zzh.exercise.context;

import com.zzh.exercise.entity.Student;

import java.util.List;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/23
 */
public interface HandlerContext {

    void buildContext(Student student);

    List<?> result();
}
