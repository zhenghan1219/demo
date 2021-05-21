package com.zzh.exercise.math;

import org.junit.Test;

import java.util.*;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/11/5
 */


public class MathAndOrganization {

    @Test
    public void testTrans(){
        //反转为mhtirogla
        String demo = "algorithm";
        char[] chars = demo.toCharArray();
        StringBuilder tansData = new StringBuilder();
        for (int j = chars.length-1; j >= 0 ; j--) {
            tansData.append(chars[j]);
        }
        System.out.println(tansData.toString());

    }

    /**
     * LeetCode 第 242 题：给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 说明：你可以假设字符串只包含小写字母。
     * 示例 1
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    /**
     * 第一版
     */
    @Test
    public void test242(){
        //思路
        //解题：就是后边字母相同，前边字母不一定相同；问题：前边字母总共几位数？先按照示例解决
        //解答：相同字符数量相同
        //思路：每个字符都相同，先将其转换为字符数组，
        //判断数组中每个字母的数量
        //a
        //ab
        String s= "a";
        String t = "ab";
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<String ,Integer> map = new HashMap<>();
        Map<String ,Integer> newMap = new HashMap<>();
        int sCount = 0;
        int tCount = 0;
        for (char a :sChars){
            if(map.containsKey(String.valueOf(a))){
                sCount = map.get(String.valueOf(a)).intValue() +1 ;
            }else {
                sCount = 0 ;
            }
            map.put(String.valueOf(a),sCount);
        }
        for (char b :tChars){
            if(newMap.containsKey(String.valueOf(b))){
                tCount = newMap.get(String.valueOf(b)).intValue() +1 ;
            }else{
                tCount = 0;
            }
            newMap.put(String.valueOf(b),tCount);
        }
        Iterator<String> iterator = map.keySet().iterator();
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()){
            String key = iterator.next();
            Integer value = map.get(key);
            Integer tValue = newMap.get(key);
            if(value.equals(tValue)){
                list.add("true");
            }else {
                list.add("false");
            }
        }
        System.out.println(list.iterator());
        if (list.contains("false")) {
            System.out.println("false");
        }else {
            System.out.println("true");
        }
    }

    /**
     * 解题直接使用Arrays.sort()进行排序
     *
     */
    @Test
    public void otherPepleResult242_1(){
        String s= "abccca";
        String t = "abcacc";
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        System.out.println(String.valueOf(chars).equals(String.valueOf(chars1)));
    }

    /**
     * 解题解答：
     *  遍历当前的字符，减去开始字符'a'，可计算出一个数字，对计算的数字进行累加，
     *  然后对累加的两个char数组数据进行比较，
     *
     * 可以利用两个长度都为 26 的字符数组来统计每个字符串中小写字母出现的次数，然后再对比是否相等；
     * 可以只利用一个长度为 26 的字符数组，将出现在字符串 s 里的字符个数加 1，而出现在字符串 t 里的字符个数减 1，最后判断每个小写字母的个数是否都为 0。
     */
    @Test
    public void otherPepleResult242_2(){
        String s= "abccca";
        String t = "abcacc";
        char[] s1 = new char[26];
        char[] s2 = new char[26];
        for (char c : s.toCharArray()){
            s1[c-'a'] ++;
        }
        for (char c : t.toCharArray()){
            s2[c-'a'] ++;
        }
        System.out.println(Arrays.equals(s1,s2));
    }

    @Test
    public void testChar(){
        char a = 'a';
        System.out.println('c'-a);
    }

    /**
     * LeetCode 第 25 题：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。k 是一个正整数，
     * 它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 说明：
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例：
     * 给定这个链表：1->2->3->4->5
     * 当 k=2 时，应当返回：2->1->4->3->5
     * 当 k=3 时，应当返回：3->2->1->4->5
     */
    @Test
    public void testLeetCode25(){

    }

    @Test
    public void testMath(){
        System.out.println(Math.max(10,20));
        //求整数的平方；
        double pow = Math.pow(10d, 2d);
        System.out.println(pow);
        //取余
        int i = Math.floorMod(10, 3);
        System.out.println(i);
        //取商，取无限最大值，没有四舍五入
        int i1 = Math.floorDiv(10, 4);

        System.out.println(i1);

        int i2 = Math.floorDiv(10, 2);
        System.out.println(i2);

    }
}
