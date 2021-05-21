package com.zzh.exercise.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/17
 */
public class ArraysDynamicSum {

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     *
     * 请返回 nums 的动态和。
     *
     * 示例1
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
     * 示例2
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]
     * 示例3
     * 输入：nums = [3,1,2,10,1]
     * 输出：[3,4,6,16,17]
     *
     * 提示：
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     */

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        int resultNums[]=new int[5];
        for (int i = 0; i < nums.length; i++) {
            if (i <= 0 ){
                resultNums[i] = resultNums[0]+nums[i];
            }else {
                resultNums[i] = resultNums[i-1]+nums[i];
            }
            System.out.println(resultNums[i]);
        }
    }

}