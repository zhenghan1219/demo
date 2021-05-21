package com.zzh.exercise.dao.impl;

import com.zzh.exercise.dao.MongodbDAO;
import com.zzh.exercise.entity.MongodbEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/13
 */
@Component
public class MongodbDAOImpl implements MongodbDAO {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveDemo(MongodbEntity demoEntity) {
        mongoTemplate.save(demoEntity);
    }

    @Override
    public void removeDemo(Long id) {
        MongodbEntity entity = new MongodbEntity();
        entity.setId(id);
        mongoTemplate.remove(entity);
    }

    @Override
    public void updateDemo(MongodbEntity demoEntity) {
        Query query = new Query(Criteria.where("id").is(demoEntity.getId()));

        Update update = new Update();
        update.set("title",demoEntity.getTitle());
        update.set("by",demoEntity.getBy());
        update.set("description",demoEntity.getDescription());
        update.set("url",demoEntity.getUrl());
        mongoTemplate.updateFirst(query,update,MongodbEntity.class);
    }

    @Override
    public MongodbEntity findDemoById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, MongodbEntity.class);
    }
}
