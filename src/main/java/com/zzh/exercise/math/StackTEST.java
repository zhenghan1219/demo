package com.zzh.exercise.math;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Stack;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/11/17
 */
public class StackTEST {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        List<Integer> list= Lists.newArrayList(23, 25, 21, 19, 22, 26, 23);
        for (int i = 0; i <list.size() ; i++) {
            stack.push(list.get(i));
        }
        for (int i = 0; i < stack.size(); i++) {
            Object pop = stack.pop();
            System.out.println(pop);
        }
    }
}
