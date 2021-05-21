package com.zzh.exercise.math;

/**
 * @Author: Zhenghan
 * @Description: 求最少跳跃几次
 *
 * @Date: Create by 2021/4/19
 */
public class JumpLess {


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};

        int jump = 1;
        int count = 0;
        int jumpLength = 0;
        for (int i = 0; i <= nums.length; i++) {
            //获取下标数据
             jump += nums[i] ;
             int length = nums[nums.length-1];
             if(jump == length){
                 count = i;
                 break;
             }
            i = jump+1;
        }
        System.out.println(count);
    }
}
