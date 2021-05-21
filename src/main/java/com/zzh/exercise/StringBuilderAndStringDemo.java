package com.zzh.exercise;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/9/29
 */
public class StringBuilderAndStringDemo {

    public static void main(String[] args) {

        String a = "hello";
        StringBuilder builder = new StringBuilder();
        builder.append("hell");
        builder.append("o");

        StringBuffer buffer = new StringBuffer();
        buffer.append("hell");
        buffer.append("o");
        System.out.println("a:"+a);
        System.out.println("builder:"+builder);
        System.out.println("buffer:"+buffer);
        System.out.println(a.equals(buffer));
        System.out.println(buffer.equals(builder));
        System.out.println(builder.equals(a));

    }
}
