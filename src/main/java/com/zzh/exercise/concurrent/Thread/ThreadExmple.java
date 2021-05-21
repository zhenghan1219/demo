package com.zzh.exercise.concurrent.Thread;

/**
 * @Author: Zhenghan
 * @Description:
 * x并不需要定义为volatile, 程序里可以有需要类似x的变量，我们只需要一个volatile变量b来确保线程a能看到线程1对x的修改：
 * 根据代码顺序规则，线程1的x=5; happens-before b=1;; 线程2的int dummy = b; happens-before while(x!=5);
 * 根据volatile变量规则，线程2的b=1; happens-before int dummy=b;
 * 根据传递性，x=5; happens-before while(x!=5);
 * @Date: Create by 2021/2/23
 */
public class ThreadExmple {

    int x = 0;
    volatile int b = 0;

    private void write(){
        x = 5 ;
        b = 1;
        System.out.println("write:x="+x+" and b="+b);
    }

    private void read(){
        int dummy = b;
        System.out.println("read :x="+x+" and b="+b+" and dummy="+dummy);
        while (x != 5){
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadExmple exmple = new ThreadExmple();
        Thread thread = new Thread( new Runnable(){
            @Override
            public void run() {
                exmple.write();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                exmple.read();
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

    }

}
