package com.zzh.exercise.javaBase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/14
 */
public class StringDemo {

    @Test
    public void test_concat(){
        String a ="会员卡";
        String b = "这是个很长的食材啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊";
        System.out.println(b.length());
    }

    @Test
    public void test_blank(){
        String a = "  hello  world!  ";
        System.out.println(StringUtils.trim(a));
        a.replace("  "," ");
        String[] split = a.split(" ");
        StringBuilder builder = new StringBuilder();
        int count  =0;
        for (int i = split.length -1 ; i > 0; i--) {
            builder.append(split[i]).append(" ");
        }
        String b = "aA";
        String c = "aAAbbbb";
        if (c.contains(b)) {
            System.out.println(c.indexOf(b)+b.length()+1);
        }else {
            System.out.println("------0----");
        }

    }

    @Test
    public void test_list(){
        String a = "a,b,c";
        String b = "b,d,f";
        StringBuilder todayGoodsId = null;
        System.out.println(todayGoodsId.append("ada"));

    }
    /**
     * 第一次 AB
     * 手动修改 C
     * 第二次 AB/A/B/BA ==>和第一次一致
     */
    @Test
    public void test_regex(){
        String first = "A,B";
        String second = "B,A";

        String[] split = first.split(",");
        String[] split1 = second.split(",");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        List<String> list1 = new ArrayList<>();
        list1.add("b");
        list1.add("c");
      /*  List<String> collect = list.stream().sorted().collect(Collectors.toList());
        List<String> collect1 = list1.stream().sorted().collect(Collectors.toList());
        boolean b = collect.containsAll(collect1);
        System.out.println(b);
        boolean b1 = collect.removeAll(collect1);
        System.out.println(b1);*/
        boolean b = list.containsAll(list1);
        boolean b1 = list.removeAll(list1);
        //list.retainAll(list1);
        System.out.println(b1);
        System.out.println(b);
        //排序之后再比较
        if(list.size()>0){
            System.out.println(list.toString());
            System.out.println("有交集");
        }else {
            System.out.println(list.toString());
            System.out.println("没有交集");
        }

    }

    @Test
    public void test_split(){
        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            list.add(i);
        }
        int startIndex = 0;
        int endIndex = 10;
        for (int i = 0; i < list.size(); i++) {
            if (list.size() > 10) {
                List<Integer> subLit = list.subList(startIndex, endIndex);
                newList.addAll(subLit);
                newList.forEach(integer -> {
                    System.out.println("this is -->"+integer);
                });
                list.removeAll(subLit);
                list.forEach(integer -> {
                    System.out.println("list is =="+integer);
                });
            }else{
                newList.addAll(list);
            }
        }

    }

    @Test
    public void test(){
        String a = "   ";
        System.out.println(StringUtils.isEmpty(a));
        System.out.println(StringUtils.isBlank(a));
        List<String> list  = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");

        long count = list.stream().distinct().count();
        System.out.println(list.size());
        System.out.println(count);
    }
}
