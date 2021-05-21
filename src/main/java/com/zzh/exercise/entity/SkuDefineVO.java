/*
 * Copyright (c) 2016 ngmm365.com All rights reserved.
 */

package com.zzh.exercise.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ford
 * @create 2016-10-12 17:09
 */
@Data
public class SkuDefineVO implements Serializable {

    private static final long serialVersionUID = -4419944190176275150L;
    private Long id;

    /**
     * sku编号
     */
    private Long    skuId;
    /**
     * 商品id
     */
    private Long    goodsId;
    /**
     *  属性选项值顺序与商品的属性列表对应
     */
    private String optionCode;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 原价，教育线拼搭盒子购买组合用
     */
    private Integer originalPrice;

    private Integer originSellPrice;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 商家编码
     */
    private String  sellerCode;
    /**
     * 销量
     */
    private Integer sales;
    /**
     * sku对应的图片
     */
    private String skuImg;
    /**
     * 税费层级
     * 0-无税费
     * 1-15%税费
     * 2-30%税费
     */
    private Integer taxLevel;

    /**
     * app专享价
     */
    private Integer appPrice;

    /**
     * 老用户专享价
     */
    private Integer oldUserAppPrice;

    /**
     * 重量
     */
    private Integer weight;

    /**
     * 是否包税
     */
    private Integer inclusiveTax;

    /**
     * 活动价
     */
    private Integer activityPrice;

    /**
     * 扩展字段
     */
    private String feature;

    /**
     * 子skuId(教育线拼搭盒子组合课程使用)
     */
    private String mixSkuId;

    /**
     * 权重值
     */
    private Integer sortValue;

    private Map<String, String> featureMap;

    public String getFeatureProp(String key) {
        if (featureMap == null) {
            if (feature != null && feature.length() > 0) {
                featureMap = new HashMap<>(16);
                JSONObject jsonObj = JSONObject.parseObject(feature);
                for (String jsonKey : jsonObj.keySet()) {
                    Object jsonValue = jsonObj.get(jsonKey);
                    if (jsonValue instanceof String) {
                        featureMap.put(jsonKey, (String) jsonValue);
                    } else {
                        featureMap.put(jsonKey, JSONObject.toJSONString(jsonObj.get(jsonKey)));
                    }
                }
            }
        }

        if (featureMap != null) {
            return featureMap.get(key);
        }
        return null;
    }
}
