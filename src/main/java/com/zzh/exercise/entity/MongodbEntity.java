package com.zzh.exercise.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/13
 */
//指定集合是哪个集合
@Document(collection = "col")
@Data
public class MongodbEntity implements Serializable {

    private static final long serialVersionUID = 8494896560969824155L;

    @Id
    private Long id;

    private String title;

    private String description;

    private String by;

    private String url;
}
