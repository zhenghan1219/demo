/*
 * Copyright (c) 2017 ngmm365.com All rights reserved.
 */

package com.zzh.exercise.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ford
 * @create 2017-02-22 10:27
 */
@Data
public class GoodsPropDefineVO implements Serializable{
    /**
     * 商品属性名称
     */
    private String          propName;
    /**
     * 序号
     */
    private Integer         propOrderNo;
    /**
     * 属性选项值定义
     */
    private List<String>    optionNames;

    public void addOptionName(String optionName){
        if (optionNames == null){
            optionNames = new LinkedList<>();
        }
        optionNames.add(optionName);
    }
}
