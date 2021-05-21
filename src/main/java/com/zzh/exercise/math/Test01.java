package com.zzh.exercise.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Scanner;

/**
 * @Author: Zhenghan
 * @Description: 输出其中最大数
 * @Date: Create by 2020/12/2
 */
@Slf4j
public class Test01 {

    public static void main(String[] args) {
        int [] nums = {1,2,3};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (nums[i] > nums[i++]){
                System.out.println(nums[i]);
            }
        }
    }

    @Test
    public void testMath(){
        Integer v = Integer.valueOf(String.valueOf(Math.random() * 100000).substring(0,5));
        System.out.println(Integer.valueOf(v));
    }
}
