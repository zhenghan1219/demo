package com.zzh.exercise;

import com.alibaba.fastjson.JSONObject;
import com.zzh.exercise.entity.Student;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:  测试java 自带的函数式接口
 * @Date: Create by 2020/10/26
 */
public class LambdaTest {

    static {

    }


    /**
        Predicate.test();
        test是其抽象方法，判断真假
     */
    @Test
    public void testPredicate(){
        Predicate<Integer> predicate = x -> x > 185;
        System.out.println(predicate.test(180));
        String s = "PlatformGetRoleRightsByTypeRequest";
        System.out.println(s.toUpperCase(Locale.ROOT));
    }

    @Test
    public void mapTransJson(){
        Map<String ,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderNo","1231");
        jsonObject.put("list",map);
        System.out.println(jsonObject);
        //传递参数 解冻isPartUnfreeze true，orderNo ,skuCode,unFreezeNum
    }

    public List<Student> studentList(){
        Student s1 = new Student();
        s1.setName("zhangsan");
        s1.setAge(1);
        Student s2 = new Student();
        s2.setName("zhangsan1");
        s2.setAge(2);
        Student s3 = new Student();
        s3.setName("zhangsan2");
        s3.setAge(3);
        Student s4 = new Student();
        s4.setName("121");
        s4.setAge(4);
        Student s5 = new Student();
        s5.setName(null);
        s5.setAge(5);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        return list;
    }
    /**
     * 统计list中，对某个字段进行分组和统计数量
     */
    @Test
    public void groupAttributeAndCount(){
        List<Student> list = this.studentList();
        //System.out.println(list.size());
        list.forEach(student -> {
            //System.out.println(student.getName());
        });
        Map<String, Long> collect = list.stream()
                .filter(student -> student.getName() != null)
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        Iterator<String> iterator = collect.keySet().iterator();
        while (iterator.hasNext()){
        String key = iterator.next();
            System.out.println(key);
            System.out.println(collect.get(key));
        }
    }

    @Test
    public void testListGetName(){
        List<Student> list = this.studentList();
        List<String> collect = list.stream().map(Student::getName).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }

    @Test
    public void testDateString(){
        LocalDate localDate = stringFormatLocalDate("2020-12-08 12:12:12");
        System.out.println(localDate);
    }
    public static LocalDate stringFormatLocalDate(String date){
        return LocalDate.parse(date);
    }

    @Test
    public void testDiv(){
        System.out.println();
        for (int i = 0; i < 1005/100; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void testNumber(){
        int i =2;

    }

}
