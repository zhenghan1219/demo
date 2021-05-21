package com.zzh.exercise.concurrent.Thread;

/**
 * @Author: Zhenghan
 * @Description: CAS
 * @Date: Create by 2021/2/23
 */
public class CASTest {

    private boolean locker = false;

    public boolean Lock(){
        if (!locker){
            locker = true;
            return true;
        }
        return false;
    }
}
