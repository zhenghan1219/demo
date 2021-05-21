package com.zzh.exercise.javaBase;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zzh.exercise.designPattern.builder.User;
import com.zzh.exercise.entity.Student;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/23
 */
public class CollectionsTest {

    public void test_ArrayList(){
        List<String> list = new ArrayList<>();
        list.subList(0,200);

        Lists.partition(list,200);
    }

    /**
     * Spliterator 是 Java 8 引入的新接口，顾名思义，Spliterator 可以理解为 Iterator 的 Split 版本（但用途要丰富很多）。
     *
     * 使用 Iterator 的时候，我们可以顺序地遍历容器中的元素，使用 Spliterator 的时候，我们可以将元素分割成多份，分别交于不于的线程去遍历，以提高效率。
     *
     * 使用 Spliterator 每次可以处理某个元素集合中的一个元素 — 不是从 Spliterator 中获取元素，而是使用 tryAdvance() 或 forEachRemaining() 方法对元素应用操作。
     *
     * 但 Spliterator 还可以用于估计其中保存的元素数量，而且还可以像细胞分裂一样变为一分为二。这些新增加的能力让流并行处理代码可以很方便地将工作分布到多个可用线程上完成。
     * @throws Exception
     */
    @Test
    public void testLinkedList() throws Exception{
        LinkedList<Student> linkedList = new LinkedList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        LinkedList<Student> students = (LinkedList<Student>) StudenBase.studentList(linkedList);

        Spliterator<Student> spliterator = students.spliterator().trySplit();

        spliterator.forEachRemaining(a ->{
            executorService.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println("姓名："+a.getName()+" name is -->"+Thread.currentThread().getName());
                    System.out.println("年龄："+a.getAge()+" name is -->"+Thread.currentThread().getName());
                }
            });

        });

        new LinkedHashMap<>();
        new HashMap<>();
    }

    @Test
    public void testMap(){
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,2);
    }

    @Test
    public void testFilter(){
        List<User.UserBuilder> list = new ArrayList<>();
        list.add(new User.UserBuilder("zhangsan","a"));
        List<User.UserBuilder> name = list.stream().filter(s -> s.build().getFirstName().equals("a")).collect(Collectors.toList());
        name.forEach( userBuilder -> {
            System.out.println(userBuilder.build().getFirstName());

        });

    }

    @Test
    public void test_manyMap(){
        Collection<String>  collection = new ArrayList<>();
        collection.add("a");
        System.out.println(collection.toString());
    }

    @Test
    public void test_mapIsNull(){
        Map<String,String> map = new HashMap<>();
        List<String> collect = map.values().stream().collect(Collectors.toList());
        System.out.println(collect);
    }

}
