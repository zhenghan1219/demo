package com.zzh.exercise;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/11/18
 */
public class ExecutorsTest {

    @Test
    public void testAtomicInteger(){

        AtomicInteger atomicInteger = new AtomicInteger();
        int i1 = atomicInteger.addAndGet(1);
        System.out.println(i1);
    }

}
