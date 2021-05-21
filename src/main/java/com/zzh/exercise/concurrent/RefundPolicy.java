package com.zzh.exercise.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/11/16
 */
@Slf4j
public class RefundPolicy {
    static AtomicLong sum = new AtomicLong(0);
    static int count = 100;
    public static void main(String[] args) {
        //中止策略  抛弃任务且抛出异常RejectedExecutionException
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS,new  LinkedBlockingQueue(2),new ThreadPoolExecutor.AbortPolicy());
        //调用者运行策略 交由调用者处理线程，主线成不再接收新任务，因此线程池内的业务线程有时间处理其他线程；
        //线程不会中断
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS,new  LinkedBlockingQueue(2),new ThreadPoolExecutor.CallerRunsPolicy());
        //抛弃老任务  老得线程提出
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS,new  LinkedBlockingQueue(2),new ThreadPoolExecutor.DiscardOldestPolicy());
        //抛弃策略 把新加入的都给抛弃了
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS,new  LinkedBlockingQueue(2),new ThreadPoolExecutor.DiscardPolicy());
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i <count ; i++) {
            try {
                executor.execute(new TestRunnable());
            } catch (Exception e) {
                log.error("出现错误：{}", e.getMessage());
            }
        }
    }
}
