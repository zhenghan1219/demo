package com.zzh.exercise.concurrent.Thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/11/30
 */
public class ThreadState {

        public static void main(String[] args) {
            new Thread(()->{
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"thread01_status").start();  //阻塞状态

            new Thread(()->{
                while(true){
                    synchronized (ThreadState.class){
                        try {
                            ThreadState.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            },"thread02_status").start(); //阻塞状态

            new Thread(new BlockedDemo(),"BLOCKED-DEMO-01").start();
            new Thread(new BlockedDemo(),"BLOCKED-DEMO-02").start();

        }
        static class BlockedDemo extends  Thread{
            @Override
            public void run() {
                synchronized (BlockedDemo.class){
                    while(true){
                        try {
                            TimeUnit.SECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
