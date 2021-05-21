package com.zzh.exercise;

import java.util.*;

public class GetHashO {

    public static void main(String[] args) {
        /*Student student = new Student();
        student.setAge("10");
        HashMap<String ,Student> hash10 = new HashMap<>();
        hash10.put("age",student);
        int hash = hash10.get("age").hashCode();
        System.out.println(hash);
        System.out.println("---"+ hash % count  );*/
        int count = 10 ;
        int pushNum = 10;
        String userID = "29019304";
        int hashNum = hash(userID);
        if (hashNum % count    < pushNum ){
            System.out.println("this is ---"+hashNum % count);
        }else {
            System.out.println("this is not ---"+hashNum % count);
        }


    }

    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }
}
