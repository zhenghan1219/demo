package com.zzh.exercise.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fengjian
 * @version V1.0
 * @title: workspace
 * @Package com.zhicong.goods.entity
 * @Description:
 * @date 2017/9/4 下午8:14
 */
@Data
public class GoodsMallVO implements Serializable{
    private static final long serialVersionUID = -795811169655919145L;
    private Integer id;
    private String name;
    private String appId;
}
