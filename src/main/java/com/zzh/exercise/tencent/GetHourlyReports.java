package com.zzh.exercise.tencent;

import com.tencent.ads.ApiContextConfig;
import com.tencent.ads.TencentAds;
import com.tencent.ads.exception.TencentAdsResponseException;
import com.tencent.ads.exception.TencentAdsSDKException;
import com.tencent.ads.model.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/7
 */
public class GetHourlyReports implements Serializable {




    /** YOUR ACCESS TOKEN */
    public String ACCESS_TOKEN = "9fa77597b21a580fef77e9ed1b665b70";

    /** TencentAds */
    public TencentAds tencentAds;

    public Long accountId = 3379367L;

    public String level = "REPORT_LEVEL_AD_WECHAT";

    public DateRange dateRange = new DateRange();

    public List<FilteringStruct> filtering = null;

    public List<String> groupBy = null;

    public List<OrderByStruct> orderBy = null;

    public Long page = null;

    public Long pageSize = null;

    public String timeLine = null;

    public List<String> fields =
            Arrays.asList("hour", "view_count", "valid_click_count", "ctr", "cpc", "cost");

    public void init() {
        this.tencentAds = TencentAds.getInstance();
        this.tencentAds.init(
                new ApiContextConfig().accessToken(ACCESS_TOKEN).isDebug(true)); // debug==true 会打印请求详细信息
        //this.tencentAds.useSandbox(); //默认使用沙箱环境，如果要请求线上，这里需要设为线上环境
        //this.tencentAds.useProduction(); //生产环境
        this.buildParams();
    }

    public void buildParams() {
        String startDate = "REPORT DATE";
        dateRange.setStartDate(startDate);
        String endDate = "REPORT DATE";
        dateRange.setEndDate(endDate);
    }

    public HourlyReportsGetResponseData getHourlyReports() throws Exception {
        dateRange.setStartDate("2020-12-07");
        dateRange.setEndDate("2020-12-07");
        HourlyReportsGetResponseData response =
                tencentAds
                        .hourlyReports()
                        .hourlyReportsGet(
                                accountId, level, dateRange, filtering, groupBy, orderBy, page, pageSize, timeLine,
                                fields);

        return response;
    }

    public static void main(String[] args) {
        try {
            GetHourlyReports getHourlyReports = new GetHourlyReports();
            getHourlyReports.init();
            HourlyReportsGetResponseData response = getHourlyReports.getHourlyReports();
            List<HourlyReportsGetListStruct> list = response.getList();
            System.out.println(list);

        } catch (TencentAdsResponseException e) {
            e.printStackTrace();
        } catch (TencentAdsSDKException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
