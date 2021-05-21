package com.zzh.exercise.javaBase;

import com.zzh.exercise.entity.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/30
 */
public class StudenBase {

    public static Collection studentList(Collection collection){
        Student student = new Student();
        student.setAge(10);
        student.setName("张三");
        Student student1 = new Student();
        student1.setAge(20);
        student1.setName("里斯");
        Student student2 = new Student();
        student2.setAge(31);
        student2.setName("Tom");
        Student student3 = new Student();
        student3.setAge(29);
        student3.setName("Jack");
        Student student4 = new Student();
        student4.setAge(18);
        student4.setName("Marry");
        Student student5 = new Student();
        student5.setAge(25);
        student5.setName("Lily");
        collection.add(student);
        collection.add(student1);
        collection.add(student2);
        collection.add(student3);
        collection.add(student4);
        collection.add(student5);
        return collection;
    }
}
