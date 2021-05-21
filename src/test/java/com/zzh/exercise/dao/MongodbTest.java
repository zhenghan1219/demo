package com.zzh.exercise.dao;

import com.alibaba.fastjson.JSONObject;
import com.zzh.exercise.DemoApplication;
import com.zzh.exercise.entity.MongodbEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MongodbTest {

    @Autowired
    private MongodbDAO mongodbDAO;

    @Test
    public void test_save(){
        MongodbEntity entity = new MongodbEntity();
        entity.setId(1L);
        entity.setTitle("保存");
        entity.setDescription("测试保存");
        entity.setBy("zhenghan");
        entity.setUrl("www.baidu.com");
        mongodbDAO.saveDemo(entity);

        entity = new MongodbEntity();
        entity.setId(2L);
        entity.setTitle("保存一下");
        entity.setDescription("保存一个数据2");
        entity.setBy("张三");
        entity.setUrl("www.alibaba.com");
        mongodbDAO.saveDemo(entity);
    }

    /**
     * 如果id不存在也会显示成功
     */
    @Test
    public void test_update(){
        MongodbEntity entity = new MongodbEntity();
        entity.setId(1L);
        entity.setTitle("保存4");
        entity.setDescription("李四保存");
        entity.setBy("lisi");
        entity.setUrl("www.meituan.com");
        mongodbDAO.updateDemo(entity);
    }

    @Test
    public void test_findOne(){
        MongodbEntity demoById = mongodbDAO.findDemoById(1L);
        System.out.println(JSONObject.toJSON(demoById));
    }

    @Test
    public void test_remove(){
        mongodbDAO.removeDemo(2L);
    }

}
