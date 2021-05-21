package com.zzh.exercise.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/17
 */
public class SameCharsCount {

    /**
     *给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
     *
     * 请你返words数组中一致字符串 的数目
     *
     * 例1：
     * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
     * 输出：2
     * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
     *
     * 例2：
     * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
     * 输出：7
     * 解释：所有字符串都是一致的。
     *
     * 例3 ：
     *输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
     * 输出：4
     * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
     *
     * 提示：
     * 1 <= words.length <= 104
     * 1 <= allowed.length <= 26
     * 1 <= words[i].length <= 10
     * allowed中的字符 互不相同。
     * words[i] 和allowed只包含小写英文字母。
     */

    public static void main(String[] args) {

    }


    @Test
    public void test(){
        String a = "abc";
        String b = "ab";
        System.out.println(a.contains(b));
    }
}
