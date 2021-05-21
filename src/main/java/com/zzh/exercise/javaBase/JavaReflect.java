package com.zzh.exercise.javaBase;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import com.zzh.exercise.entity.Student;
import org.junit.Test;
import org.springframework.cglib.reflect.FastClass;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/25
 */
public class JavaReflect {

    @Resource
    ApplicationContext applicationContext;
    @Test
    public void test(){
        System.out.println(Student.class);
        List<Student> students = new ArrayList<Student>();
        Student stu = new Student();
        stu.setSex(true);
        students.add(stu);
        System.out.println(getFirstActualType(students, 0));
        System.out.println(Student.class.getSimpleName());
        Student bean = this.applicationContext.getBean(Student.class);
        FastClass.create(bean.getClass());
    }

    /**
     * list中有值才可以进行获取
     * @param o
     * @param index
     * @return
     */
    public static Object getFirstActualType(Object o, int index){
        Type genericSuperclass = o.getClass().getGenericSuperclass();
        ParameterizedType superclass = (ParameterizedType) genericSuperclass;
        return superclass.getActualTypeArguments()[index];
    }

    @Test
    public void testO(){
        List<Student> list = new ArrayList<>();
        System.out.println();
        Type genericSuperclass = list.getClass().getGenericSuperclass();
        ParameterizedType cka = (ParameterizedType) genericSuperclass;
        System.out.println(cka);
        System.out.println(cka.getActualTypeArguments()[0]);
    }


}
