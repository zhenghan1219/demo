package com.zzh.exercise.dao;

import com.zzh.exercise.entity.MongodbEntity;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/13
 */
public interface MongodbDAO {

    void saveDemo(MongodbEntity demoEntity);

    void removeDemo(Long id);

    void updateDemo(MongodbEntity demoEntity);

    MongodbEntity findDemoById(Long id);
}
