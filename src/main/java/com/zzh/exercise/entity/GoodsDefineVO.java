/*
 * Copyright (c) 2016 ngmm365.com All rights reserved.
 */

package com.zzh.exercise.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ford
 * @create 2016-10-12 16:28
 */
@ToString(of = {"id", "name", "sellPrice", "appPrice", "oldUserAppPrice"})
@Data
public class GoodsDefineVO implements Serializable {

    private static final long serialVersionUID = 2034258096720132567L;

    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;

    /**
     * 副标题
     */
    private String subName;

    /**
     * 渠道
     */
    private Integer channel;
    /**
     * 商品介绍
     */
    private String description;

    /**
     * 商家编码
     */
    private String sellerCode;
    /**
     * 商品库存
     */
    private Integer stock;
    /**
     * 限购数量
     */
    private Integer restriction;
    /**
     * 类目
     */
    private String category;
    /**
     * 原价，单位分
     */
    private Integer originalPrice;
    /**
     * 售价，单位分
     */
    private Integer sellPrice;
    private Integer originSellPrice;
    /**
     * 运费模板id
     */
    private Integer freightId;
    /**
     * 邮费
     */
    private Integer postage;
    /**
     * 商品图片列表
     */
    private List<String> pictures;
    /**
     * 商品状态，
     * 1-上架；
     * 2-下架
     * 3-预售
     */
    private Integer status;
    /**
     * 开售时间，格式：yyyy-MM-dd HH:mm:ss
     */
    //private String onsaleTime;
    /**
     * 销量
     */
    private Integer sales;

    /**
     * 是否存在sku
     */
    private Boolean existSku;

    /**
     * 属性列表顺序与sku中的属性选项值顺序对应
     */
    private List<GoodsPropDefineVO> goodsPropVos;

    /**
     * sku列表
     */
    private List<SkuDefineVO> skus;

    /**
     * 图文信息
     */
    private String details;

    /**
     * 创建时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String createTime;

    /**
     * 倒计时时间,单位:毫秒
     */
    private Long countDownTime;

    /**
     * 是否团商品(被废弃)
     */
    @Deprecated
    private Integer groupBuy;

    /**
     * 是否海淘 0:海淘/1:正常
     */
    private Boolean haitao;

    /**
     * 是否虚拟商品
     */
    private boolean virtual;

    /**
     * 商品标签
     */
    private List<GoodsLabelVO> labelList;

    private List<Long> labels;

    /**
     * 是否隐藏开售时间  0:隐藏/1:不隐藏
     */
    private Integer hiddenOnSaleTime;

    private Long categoryId;

    private String categoryName;

    //----------活动-----------
    private Long activityId;

    private Integer v;

    private String activityUrl;

    /**
     * 活动状态
     */
    private Integer activityStatus;

    /**
     * 活动开始时间
     */
    private Date activityStartTime;

    /**
     * 活动结束时间
     */
    private Date activityEndTime;

    /**
     * 是否新人
     */
    private Integer activityJoinUser;

    /**
     * 是否可加购 1：是 0：否
     */
    private Integer addCart;

    /**
     * 是否包邮
     */
    private Integer activityFreeShipping;

    /**
     * 活动标签
     */
    private String activityLabel;

    /**
     * 活动上商品的限购
     */
    private Integer activityBuyLimit;

    /**
     * 活动库存
     */
    private Integer activityStock;

    /**
     * 活动是否锁库存
     */
    private Integer lockStock;

    /**
     * 是否秒杀活动
     */
    private Boolean secKill;

    /**
     * 禁止使用优惠券
     */
    private Integer forbidUseCoupon;

    /**
     * 禁止使用活动
     */
    private Integer forbidUseCampaign;

    /**
     * 活动价
     */
    private Integer activityPrice;

    //----------活动-----------

    /**
     * 店铺信息
     */
    private GoodsMallVO goodsMallVO;

    private Integer appPrice;//app专享价

    private Integer oldUserAppPrice;//老用户专享价

    private Integer syncStock;//1同步，0不同步

    private Integer appDiscount;//app专享价折扣
    private Integer oldUserAppDiscount;//老用户app专享价折扣


    private String extension;//商品扩展

    private Integer selfFlag;

    private Integer isMakeUp;

    private Integer mallId;//店铺id

    private Integer isShield;//是否屏蔽搜索 0：不屏蔽 1：屏蔽

    private Integer activityTypes;


    /**
     * 测款状态 0未测款 1待测款 2测款中 3测款结束
     */
    private Integer testStatus;
    /**
	 * 采购小组
	 */
	private String purchaseTeam;


    /**
     * 是否会员商品
     */
    private Boolean isMemberGoods;

    /**
     * 是否自营
     */
    private Integer isSelfBrand;

    /**
     * 是否供应商发布的商品
     */
    private Integer isShop = 0;

    private Map<String, String> extProperties;

    private static final Logger logger = LoggerFactory.getLogger("running");

    public String getProperty(String key) {
        if (extProperties == null) {
            try {
                if (extension != null && extension.length() > 0) {
                    extProperties = new HashMap<>(16);
                    JSONObject jsonObj = JSONObject.parseObject(extension);
                    for (String jsonKey : jsonObj.keySet()) {
                        Object jsonValue = jsonObj.get(jsonKey);
                        if (jsonValue instanceof String) {
                            extProperties.put(jsonKey, (String) jsonValue);
                        } else {
                            extProperties.put(jsonKey, JSONObject.toJSONString(jsonObj.get(jsonKey)));
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("GoodsDefineVO ERROR" + e.getMessage());
            }
        }
        if (extProperties != null) {
            return extProperties.get(key);
        }
        return null;
    }

}
