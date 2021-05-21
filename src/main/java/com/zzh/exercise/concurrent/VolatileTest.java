package com.zzh.exercise.concurrent;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/2/23
 */
public class VolatileTest {
    public static void main(String[] args) {
        Aobing ao = new Aobing();
        ao.start();
        while (true){
            if (ao.isFlag()){
                System.out.println("有点东西");
            }

        }
    }
}

 class Aobing extends Thread{
    private boolean flag = false;

    public boolean isFlag(){
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        //注意看提示，flag永远为true
        System.out.println("flag is "+flag);
    }

}

/**
 * volatile的使用
 */
class Singleton{
    //可见性和禁止重排都能保证
    private volatile static Singleton instance = null;
    //私有构造方法
    private Singleton(){}

    public static Singleton getInstance() {
        //第一重检查锁定
        if(instance == null){
            //同步锁定代码块
            synchronized (Singleton.class){
                //第二重检查锁定
                if(instance == null){
                    //注意：非原子操作
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
