package com.zzh.exercise;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void demoTest(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("3");
        list.add("6");
        list.add("7");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //1.
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        Iterator<String> coll = collect.iterator();
        while (coll.hasNext()){
            System.out.println("Java 8 去重-----");
            System.out.println(coll.next());
        }
        //2.hashset 不能保证去重顺序，所以只能进行条件判断进行排序
        HashSet<String> hashSet = new HashSet<>(list.size());
        hashSet.addAll(list);
        List<String> newList = new ArrayList<>();
        newList.addAll(hashSet);
        for (String str : hashSet){
            newList.add(str);
        }
        Iterator<String> newIter = newList.iterator();
        while (newIter.hasNext()){
            System.out.println("hashset 去重-----");
            System.out.println(newIter.next());
        }
        //3.可以保证顺序
        LinkedHashSet<String> linkedHashSet= new LinkedHashSet<>();
        linkedHashSet.addAll(list);
        ArrayList<String> arr = new ArrayList<>();
        arr.addAll(linkedHashSet);
        Iterator<String> iterator1 = arr.iterator();
        while (iterator1.hasNext()){
            System.out.println("linkedSet去重---");
            System.out.println(iterator1.next());
        }
        //

    }

}
