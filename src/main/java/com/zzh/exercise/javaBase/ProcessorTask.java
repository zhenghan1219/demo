package com.zzh.exercise.javaBase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/10/16
 */
public class ProcessorTask implements Runnable{
    Logger logger = LoggerFactory.getLogger(ProcessorTask.class);

    private CountProcessor countProcessor;
    private long loopTime;

    public ProcessorTask(CountProcessor countProcessor ,long loopTime){
        this.countProcessor = countProcessor ;
        this.loopTime = loopTime;
    }

    @Override
    public void run() {
        int i =0;
        while (i < loopTime){
            countProcessor.processor();
            i ++ ;
        }
        logger.info("Finally ,the count is {}" ,countProcessor.getCount());
    }
}
