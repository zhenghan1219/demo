package com.zzh.exercise.leetcode;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/21
 */
public class WordTranstion {

    public static void main(String[] args) {
        System.out.println(tansString("Hello World"));
    }

    /**
     * 使用三目运算符和递归
     *  三目：x ? y :z ; x为true返回y，否则返回Z
     *  递归：
     *      程序调用自身的编程技巧为递归；
     *      递归做为一种算法在程序设计语言中广泛应用。
     *      一个过程或函数在其定义或说明中有直接或间接调用自身的一种方法，
     *      它通常把一个大型复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解，
     *      递归策略只需少量的程序就可描述出解题过程所需要的多次重复计算，
     *      大大地减少了程序的代码量
     * @param word
     * @return
     */
    public static  String tansString(String word){
        return word.isEmpty() ? word:tansString(word.substring(1)) + word.charAt(0);
    }


}
