package com.zzh.exercise.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fengjian
 * @version V1.0
 * @title: workspace
 * @Package com.zhicong.goods.entity
 * @Description:
 * @date 2017/7/19 下午1:43
 */
@Data
public class GoodsLabelVO implements Serializable{
    private static final long serialVersionUID = 2989965739976959120L;

    private Long id;

    private Long itemId;

    private String itemTitle;

    private String labelName;

    private String labelImg;

    private Date createTime;

    private Date updateTime;


}
