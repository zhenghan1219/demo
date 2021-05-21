package com.zzh.exercise.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Zhenghan
 * @Description:  线程池的拒绝策略
 * @Date: Create by 2020/11/16
 */
@Slf4j
public class TestRunnable implements Runnable{

    @Override
    public void run() {
        if("main".equals(Thread.currentThread().getName())){
            log.info("main 线程出现次数：{}",RefundPolicy.sum.incrementAndGet());
        }
        log.info("线程正在运行，线程名称：{}",Thread.currentThread().getName());
    }

}
