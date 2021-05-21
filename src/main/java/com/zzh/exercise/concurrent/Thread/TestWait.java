package com.zzh.exercise.concurrent.Thread;

/**
 * @Author: Zhenghan
 * @Description:  测试wait方法
 * @Date: Create by 2020/12/1
 */
public class TestWait {
    //
    //

    /**
     * 在没有加synchronized的时候，就会抛出java.lang.IllegalMonitorStateException 异常
     * 这是因为wait方法必须在monitor的临界区内使用，而在Java中实现的monitor临界区就需要使用synchronized修饰，被修饰的方法或代码块就是临界区
     * notify和notifyAll也相同
     * 意思是：线程试图等待对象的监视器或者试图通知其他正在等待对象监视器的线程，但是本身没有对应监视器的所有权
     * 主要原因是wait本身是一个本地方法，其底层是通过一个叫监控器锁的对象monitor完成的
     * 出现上述异常是因为wait方法没有获取到monitor对象的所有权；
     *
     */
    public  void testWaiting()  {
        System.out.println("start ------");
        try {
            wait(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("end -----");
    }

    public static void main(String[] args) {
        final TestWait testWait = new TestWait();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testWait.testWaiting();
            }
        }).start();

    }
}
