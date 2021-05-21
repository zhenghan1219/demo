package com.zzh.exercise.tencent;

/**
 * 字段维护常量
 * 返回参数的字段列表、过滤条件字段
 * @Author: wangxiaow@nicomama.com
 * @Date: 2020/12/8
 */
public interface TencentAdFieldConstant {

    /**
     * 广告组id，仅支持微信公众平台广告主
     * integer
     */
    String ADGROUP_ID = "adgroup_id";
    /**
     * 推广计划id，仅支持微信公众平台广告主
     * integer
     */
    String CAMPAIGN_ID = "campaign_id";
    /**
     * 推广计划名称
     */
    String CAMPAIGN_NAME = "campaign_name";
    /**
     * 小时(0-23)，仅支持微信公众平台广告主
     * integer
     */
    String HOUR = "hour";
    /**
     * 日期，日期格式：YYYY-MM-DD，仅支持微信公众平台广告主
     * string
     */
    String DATE = "date";
    /**
     * 广告主帐号 id
     * integer
     */
    String ACCOUNT_ID = "account_id";
    /**
     * 微信账号id，仅支持微信公众平台广告主
     * string
     */
    String WECHAT_ACCOUNT_ID = "wechat_account_id";
    /**
     * 微信服务商id，仅支持微信公众平台广告主
     * string
     */
    String WECHAT_AGENCY_ID = "wechat_agency_id";
    /**
     * 公众号关注次数，仅支持微信公众平台广告主
     * integer
     */
    String OFFICIAL_ACCOUNT_FOLLOW_COUNT = "official_account_follow_count";
    /**
     * 公众号关注成本（次数），仅支持微信公众平台广告主
     * integer
     */
    String OFFICIAL_ACCOUNT_FOLLOW_COST = "official_account_follow_cost";
    /**
     * 花费，仅支持微信公众平台广告主
     * integer
     */
    String COST = "cost";
    /**
     * 广告组日预算，单位为分，设置为 0 表示不设预算（即不限）
     */
    String DAILY_BUDGET = "daily_budget";

    /**
     * 当日成本偏差；反应广告今日的实际成本与目标成本之际差异
     * float
     */
    String COST_DEVIATION_RATE = "cost_deviation_rate";
    /**
     * 赔付金额；广告超成本时的赔付金额
     * integer
     */
    String COMPENSATION_AMOUNT = "compensation_amount";
    /**
     * 曝光次数；观看广告的次数
     * integer
     */
    String VIEW_COUNT = "view_count";
    /**
     * 千次曝光成本；平均每千次曝光的次数
     * Integer
     */
    String THOUSAND_DISPLAY_PRICE = "thousand_display_price";
    /**
     * 曝光人数；观看广告独立的用户数
     * integer
     */
    String VIEW_USER_COUNT = "view_user_count";
    /**
     * 人均曝光次数；每个用户平均观看广告的次数
     * integer
     */
    String AVG_VIEW_PER_USER = "avg_view_per_user";
    /**
     * 点击次数；用户在广告区外进行点击操作的次数
     * integer
     */
    String VALID_CLICK_COUNT = "valid_click_count";
    /**
     * 点击人数
     * integer
     */
    String CLICK_USER_COUNT = "click_user_count";
    /**
     * 点击率;广告点击次数/广告曝光次数
     * integer
     */
    String CTR = "ctr";
    /**
     * 点击均价；广告花费/广告次数
     * 类型：integer
     */
    String CPC = "cpc";
    /**
     * 可转化点击次数
     * 类型：integer
     */
    String VALUABLE_CLICK_COUNT = "valuable_click_count";
    /**
     * 可转化点击率
     * 类型：integer
     */
    String  VALUABLE_CLICK_RATE = "valuable_click_rate";
    /**
     * 可转化点击成本
     * 类型：integer
     */
    String VALUABLE_CLICK_COST = "valuable_click_cost";
    /**
     * 图片点击次数
     * 类型：integer
     */
    String CLICK_IMAGE_COUNT = "click_image_count";
    /**
     * 图片点击人数
     * 类型：integer
     */
    String IMAGE_CLICK_USER_COUNT = "image_click_user_count";
    /**
     * 视频点击次
     * 类型：integer
     */
    String VIDEO_PLAY_COUNT = "video_play_count";
    /**
     * 视频点击人数
     * 类型：integer
     */
    String VIDEO_CLICK_USER_COUNT = "video_click_user_count";
    /**
     * 文字链点击次
     * 类型：integer
     */
    String CLICK_DETAIL_COUNT = "click_detail_count";
    /**
     * 文字链点击人数
     * 类型：integer
     */
    String LINK_CLICK_USER_COUNT = "link_click_user_count";
    /**
     * 头像点击次数
     * 类型：integer
     */
    String CLICK_HEAD_COUNT = "click_head_count";
    /**
     * 头像点击人数
     * 类型：integer
     */
    String PORTRAIT_CLICK_USER_COUNT = "portrait_click_user_count";
    /**
     * 昵称点击次数
     * 类型：integer
     */
    String CLICK_NICK_COUNT = "click_nick_count";
    /**
     * 昵称点击人数
     * 类型：integer
     */
    String NICKNAME_CLICK_USER_COUNT = "nickname_click_user_count";
    /**
     * 推广页曝光次数
     * 类型：integer
     */
    String PLATFORM_PAGE_VIEW_COUNT = "platform_page_view_count";
    /**
     * 推广页曝光人数
     * 类型：integer
     */
    String PLATFORM_KEY_PAGE_VIEW_USER_COUNT = "platform_key_page_view_user_count";
    /**
     * 推广页曝光率
     * 类型：float
     */
    String PLATFORM_KEY_PAGE_VIEW_DURATION = "platform_key_page_view_duration";
    /**
     * 推广页按钮点击次数
     * 类型：integer
     */
    String CPN_CLICK_BUTTON_COUNT = "cpn_click_button_count";
    /**
     * 推广页按钮点击人数
     * 类型：integer
     */
    String CPN_CLICK_BUTTON_UV = "cpn_click_button_uv";
    /**
     * 点赞次数
     * 类型：integer
     */
    String PRAISE_COUNT = "praise_count";
    /**
     * 点赞人数
     * 类型：integer
     */
    String PRAISE_USER_COUNT = "praise_user_count";
    /**
     * 评论次数
     * 类型：integer
     */
    String COMMENT_COUNT = "comment_count";
    /**
     * 评论人数
     * 类型：integer
     */
    String COMMENT_USER_COUNT = "comment_user_count";
    /**
     * 转化目标量
     * 类型：integer
     */
    String CONVERSIONS_COUNT = "conversions_count";
    /**
     * 转化目标成本
     * 类型：integer
     */
    String CONVERSIONS_COST = "conversions_cost";
    /**
     * 目标转化率
     * 类型：float
     */
    String CONVERSIONS_RATE = "conversions_rate";
    /**
     * 公众号关注率
     * 类型：integer
     */
    String OFFICIAL_ACCOUNT_FOLLOW_RATE = "official_account_follow_rate";
    /**
     * 阅读粉丝量
     * 类型：integer
     */
    String OFFICIAL_ACCOUNT_READER_COUNT = "official_account_reader_count";
    /**
     * 不感兴趣点击次数
     * 类型：integer
     */
    String NO_INTEREST_COUNT = "no_interest_count";



}
