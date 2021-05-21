package com.zzh.exercise.javaBase;

/**
 * @Author: Zhenghan
 * @Description:  线程不安全 ，如果同时进行读-修改-写入操作，就会造成数据不一致
 *      主要是因为加载在了主内存和高速缓存中的数据不一致，导致数据修改不成功
 * @Date: Create by 2020/10/16
 */
public class UnSafeCountingProcessor implements CountProcessor {
    private long count = 0;
    @Override
    public void processor() {
        doProcessor();
        count ++ ;
    }

    @Override
    public long getCount() {
        return count;
    }

    private void doProcessor(){}
}
