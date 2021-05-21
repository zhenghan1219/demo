package com.zzh.exercise.javaBase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zzh.exercise.entity.Student;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/25
 */
public class ListTest {

    private static List<String> list = new ArrayList<>();
    private static List<String> list1 = new ArrayList<>();

    static {
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("b");
        list1.add("a");
        list1.add("1");
        list1.add("3");
        list1.add("4");
    }
    @Test
    public void test_distinct(){
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        collect.forEach(s->{
            System.out.println(s);
        });
    }

    @Test
    public void test_addAll() {
        list.addAll(list1);
        boolean contains = list.contains(list1);
        System.out.println(contains);
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        System.out.println(list1.subList(0,2));
    }


    @Test
    public void test_twoArray() {
        Map<String, String> map = new LinkedHashMap<>();
        for(int i = 0; i < 10000; i++){
            list.add(String.valueOf(i));
            list.add(String.valueOf(100000+i));
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            map.put(list1.get(i), list.get(i));
            System.out.println(map.get(list1.get(i)) + "--" + list.get(i));

        }
        //排序(goodsId,sort)
        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<String> collect = map.keySet().stream().collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

    }
    public static void otherDemo() {

       /* List<String> goodsIdList = goodsRelaAlgoList.stream()
                .filter(ingredientsGoodsRelaAlgoDO -> StringUtils.isNotEmpty(ingredientsGoodsRelaAlgoDO.getGoodsId()))
                .sorted(Comparator.comparingInt(IngredientsGoodsRelaAlgoDO::getSort).reversed())
                .map(IngredientsGoodsRelaAlgoDO::getGoodsId)
                .collect(Collectors.toList());*/
    }

    @Test
    public void test_listNull(){
        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 两种以,分割成数组
     */
    @Test
    public void test_stringSplit(){
        Student stu = new Student();
        stu.setName("赵武,王柳");
        List<String> collect = Arrays.stream(stu.getName().split(",")).map(s -> s.trim()).collect(Collectors.toList());
        collect.forEach( i -> {
            System.out.println(i);
        });

        String name = "张三,李四";
        List<String> strings = StringUtils.commaDelimitedListToSet(name).stream().collect(Collectors.toList());
        strings.forEach(s  ->{
            System.out.println(s);
        });
    }
}






