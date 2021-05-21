package com.zzh.exercise;

import com.zzh.exercise.javaBase.CountProcessor;
import com.zzh.exercise.javaBase.ProcessorTask;
import com.zzh.exercise.javaBase.UnSafeCountingProcessor;
import org.junit.Test;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/10/16
 */
public class SynchronizeProcessorTest {

    private static final int LOOP_TIME = 1000 * 10000;

    @Test
    public void test_UnThreadSafeCountingProcessor() {
        CountProcessor countProcessor = new UnSafeCountingProcessor();
        runTask(countProcessor);

    }

    private void runTask(CountProcessor countProcessor) {
        Thread thread_1 = new Thread(new ProcessorTask(countProcessor, LOOP_TIME), "thread_1");
        Thread thread_2 = new Thread(new ProcessorTask(countProcessor, LOOP_TIME), "thread_2");
        thread_1.start();
        thread_2.start();
        while (thread_1.isAlive() || thread_2.isAlive()){}
    }
}
