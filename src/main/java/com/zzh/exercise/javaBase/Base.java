package com.zzh.exercise.javaBase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzh.exercise.entity.GoodsDefineVO;
import org.junit.Test;
import sun.jvm.hotspot.oops.Instance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/9
 */
public class Base {

    /**
     作用域{}
     */
    @Test
    public void testScope(){
        {
            int x = 10 ;
            {
                int y =30;
            }
        }
        {
            int x = 20;
        }
    }

    @Test
    public void testOr(){
        System.out.println(1|1);
        System.out.println(1|0);
        System.out.println(0|0);
        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^0);
        int a = 1;
        int b =0;
        System.out.println(a|=b);
    }

    @Test
    public void testSwitch(){
        Integer c = 50;
        Integer d = Integer.valueOf(50);
        System.out.println(c==d);

        Integer e = new Integer(50);
        Integer f = new Integer(50);
        System.out.println(e==f);

        Integer g = new Integer(50);
        Integer h = new Integer(50).intValue();
        System.out.println(g==h);

        Integer i = Integer.valueOf(50);
        Integer j = new Integer(50);
        System.out.println(i==j);

    }

    @Test
    public void testHashSet(){
        HashSet<String> hash = new HashSet<>();
        hash.add("1111");
    }

    /**
     * 自动装箱
     */
    @Test
    public void testInteger(){
        //装箱； 反编译之后就是Integer i = Integer.valueOf(10);
        Integer i =10;
        //拆箱；发编译之后是：int a = integer.iniValue();
        int a = i;
    }

    /**
     * 数据结果，a==b ,c!= d;
     * 原因：
     *  因为 == 比较的是对象的引用，而equal比较的是值是否相等；
     *  jdk5以后，整型有一个缓存，但是缓存范围在-128到127之间；
     *  所以a和b读取的值都在缓存中读取的，而c和d都分别创建了一个新的对象，所以就不想等
     *  查看Integer源码，看IntegerCache，可以发现说最大值可以设置，通过-XX:AutoBoxCacheMax=size设置，java.lang.Integer.IntegerCache.high可以设置
     *  Byte, Short, Long有固定范围: -128 到 127。对于Character, 范围是 0 到 127。
     *  有ByteCache用于缓存Byte对象
     *  有ShortCache用于缓存Short对象
     *  有LongCache用于缓存Long对象
     *  有CharacterCache用于缓存Character对象
     */
    @Test
    public void testBoxCache(){
        Integer a = 3;
        Integer b = 3 ;
        if(a == b) System.out.println("a==b");
        else System.out.println("a!= b");
        Integer c = 300;
        Integer d = 300;
        if (c == d) System.out.println("c = d");
        else System.out.println("c!= d");

    }

    /**
     *
     *
     */

    @Test
    public void test_String(){
        List<GoodsDefineVO> goodsDefineVOList = new ArrayList<>();
        String s ="{\"channel\":1,\"priceMap\":{\"originSellPrice\":9900,\"oldUserAppPrice\":9900,\"memberPrice\":9700,\"newUserAppPrice\":9500},\"sellPrice\":9900,\"sales\":98190,\"details\":\"https://staticimg.ngmm365.com/34cb68918e8044ccb8df10df528f62b0\",\"goodsMallVO\":{\"appId\":\"wxf292488bb1d28004\",\"name\":\"年糕妈妈全球购\",\"id\":2},\"id\":32056,\"stock\":2221,\"goodsExtends\":{},\"discountInfo\":{\"2\":{\"campaignGuide\":\"\",\"campaignId\":2122,\"rulesDesc\":\"满2件打8折\",\"campaignLink\":\"\"},\"3\":{\"campaignGuide\":\"\",\"campaignId\":1366,\"rulesDesc\":\"\",\"campaignLink\":\"\"}},\"name\":\"Lifeline Care 婴幼儿DHA鱼油\",\"restriction\":0,\"status\":1,\"extension\":\"{\\\"memberRebate\\\":\\\"100\\\",\\\"image\\\":\\\"\\\",\\\"taxFree\\\":\\\"0\\\",\\\"channel\\\":1,\\\"firstUpTime\\\":\\\"2020-10-23 12:10:21\\\",\\\"isSelfBrand\\\":1,\\\"goodsDescAttrs\\\":[{\\\"name\\\":\\\"\\\",\\\"value\\\":\\\"\\\"}],\\\"searchKeyword\\\":\\\"鱼油,DHA,Lifeline,D3,维生素,维生素D,维D,长高,身高,春节必囤辅食,补钙必备,DHA鱼油,周年庆爆款清单,进口食品169减40,双11爆款清单,双旦礼品最高减100,\\\",\\\"urls\\\":{\\\"app\\\":{\\\"isCheck\\\":true,\\\"url\\\":{\\\"data\\\":\\\"https://m.ngmm365.com/coupons/59658?key=17ABEA9478F0698CFAFF0FAAEA889E7E\\\",\\\"type\\\":\\\"Link\\\"}},\\\"wxapp\\\":{\\\"isCheck\\\":true,\\\"url\\\":{\\\"data\\\":\\\"/pages/coupons/index?id=59658&key=17ABEA9478F0698CFAFF0FAAEA889E7E\\\",\\\"type\\\":\\\"MINIPROGRAM_LINK\\\"}},\\\"h5\\\":{\\\"isCheck\\\":true,\\\"url\\\":{\\\"data\\\":\\\"https://m.ngmm365.com/coupons/59658?key=17ABEA9478F0698CFAFF0FAAEA889E7E\\\",\\\"type\\\":\\\"Link\\\"}}},\\\"videoUrl\\\":\\\"http://video.ngmm365.com/a7f18aab908047ad9b9b348f67fe0001/e82ffacc88ff478aa5881753644644d0-8b940bd50af0075fd5860cc1daf1d4d9-ld.mp4\\\",\\\"memberDiscount\\\":\\\"9800\\\",\\\"selfFlag\\\":0,\\\"gifts\\\":[]}\",\"virtual\":false,\"skus\":[{\"skusExtends\":{},\"goodsId\":32056,\"inclusiveTax\":1,\"priceMap\":{\"originSellPrice\":9900,\"oldUserAppPrice\":9900,\"memberPrice\":9700,\"newUserAppPrice\":9500},\"sales\":98190,\"appPrice\":9900,\"sellerCode\":\"17120300500\",\"taxLevel\":1,\"optionCode\":\"30粒/盒\",\"price\":9900,\"id\":54455,\"stock\":2221}],\"originalPrice\":29800,\"description\":\"\",\"categoryName\":\"食品／营养／茶饮-营养保健-D3\",\"systemTime\":1610522553231,\"pictures\":[\"https://staticimg.ngmm365.com/47da9cbe3e0513058b3f9e0e24b84da4-w800_h800.jpg\",\"https://staticimg.ngmm365.com/90d8235603370d7193ec4626b859f381-w800_h800.jpg\",\"https://staticimg.ngmm365.com/ccecd99b72d88919f7edbf9c894711ee-w800_h800.jpg\",\"https://staticimg.ngmm365.com/ddd0f75e3404fe233b79ef56a95d6149-w800_h800.jpg\",\"https://staticimg.ngmm365.com/2016259ac7b1a61db55cd7bafa11e33c-w800_h800.jpg\"],\"sellerCode\":\"171203005\",\"freightId\":10,\"testStatus\":0,\"selfFlag\":0,\"existSku\":true,\"isShield\":0,\"goodsPropVos\":[{\"optionNames\":[\"30粒/盒\"],\"propOrderNo\":0,\"propName\":\"规格\"}],\"savePrice\":0,\"appPrice\":9900,\"postage\":0,\"createTime\":\"2018-06-03 20:15:10\",\"subName\":\"【跨境包税】纯净鱼油品质上乘，D3促进宝宝钙吸收，适合28天-3岁宝宝\",\"category\":\"食品／营养／茶饮\",\"categoryId\":171211,\"haitaoMall\":true}";
        String data = "{\"channel\":1,\"priceMap\":{\"originSellPrice\":6290,\"oldUserAppPrice\":6290,\"memberPrice\":6200,\"newUserAppPrice\":6200},\"sellPrice\":6290,\"sales\":308,\"details\":\"https://staticimg.ngmm365.com/13e950cb185040c79b5de0059eca2595\",\"goodsMallVO\":{\"appId\":\"wx1a3fbd14d1427477\",\"name\":\"年糕妈妈优选\",\"id\":1},\"id\":72526,\"stock\":135,\"goodsExtends\":{},\"discountInfo\":{\"1\":{\"campaignGuide\":\"\",\"campaignId\":1531,\"rulesDesc\":\"满299减150\",\"campaignLink\":\"\"},\"3\":{\"campaignGuide\":\"\",\"campaignId\":1366,\"rulesDesc\":\"\",\"campaignLink\":\"\"}},\"name\":\"  【2份】大希地真黑椒牛柳意面320g/份\",\"restriction\":0,\"status\":1,\"extension\":\"{\\\"image\\\":\\\"\\\",\\\"urls\\\":{\\\"app\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"Link\\\"}},\\\"wxapp\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"MINIPROGRAM_LINK\\\"}},\\\"h5\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"Link\\\"}}},\\\"videoUrl\\\":\\\"\\\",\\\"channel\\\":1,\\\"firstUpTime\\\":\\\"2020-06-18 16:57:16\\\",\\\"isSelfBrand\\\":0,\\\"goodsDescAttrs\\\":[{\\\"name\\\":\\\"\\\",\\\"value\\\":\\\"\\\"}],\\\"isNew\\\":1,\\\"searchKeyword\\\":\\\"\\\",\\\"memberDiscount\\\":\\\"9800\\\",\\\"selfFlag\\\":0}\",\"virtual\":false,\"skus\":[{\"skusExtends\":{},\"goodsId\":72526,\"inclusiveTax\":0,\"priceMap\":{\"originSellPrice\":6290,\"oldUserAppPrice\":6290,\"memberPrice\":6200,\"newUserAppPrice\":6200},\"sales\":308,\"appPrice\":6290,\"sellerCode\":\"10150200900\",\"taxLevel\":1,\"optionCode\":\"320g*2 \",\"price\":6290,\"id\":134183,\"stock\":135}],\"originalPrice\":6990,\"description\":\"\",\"categoryName\":\"食品／营养／茶饮-休闲食品-其他\",\"systemTime\":1610525372785,\"pictures\":[\"https://staticimg.ngmm365.com/2da1fa80214b68d55f7ed32afb7bd8c8-w800_h800.jpg\",\"https://staticimg.ngmm365.com/30708676241c49197f3bf5b16ac81c11-w800_h800.jpg\",\"https://staticimg.ngmm365.com/0126091c523a638310345d8e7627287a-w800_h800.jpg\",\"https://staticimg.ngmm365.com/921276cdce0eccaa7f4c06a2c42cb872-w800_h800.jpg\",\"https://staticimg.ngmm365.com/c87fbe2fbcb696bf0363173eb1ea7a8a-w800_h800.jpg\"],\"sellerCode\":\"10150200900\",\"freightId\":10,\"testStatus\":0,\"selfFlag\":0,\"existSku\":true,\"isShield\":0,\"goodsPropVos\":[{\"optionNames\":[\"320g*2 \"],\"propOrderNo\":0,\"propName\":\"规格\"}],\"savePrice\":0,\"appPrice\":6290,\"postage\":0,\"createTime\":\"2020-06-17 16:30:34\",\"subName\":\"面条口感劲道，牛肉酱味美鲜香，2分钟快手美味~\",\"category\":\"食品／营养／茶饮\",\"categoryId\":171014,\"haitaoMall\":false}";
        GoodsDefineVO goodsDefineVO = JSONObject.parseObject(s, GoodsDefineVO.class);
        GoodsDefineVO vo = JSONObject.parseObject(data, GoodsDefineVO.class);
        goodsDefineVOList.add(goodsDefineVO);
        goodsDefineVOList.add(vo);
        goodsDefineVOList.forEach(detail ->{
            System.out.println(detail.getDetails());
        });
    }

    @Test
    public void test_trans(){
        String s =  "[{\"activityBuyLimit\":5,\"activityEndTime\":1614441600000,\"activityFreeShipping\":0,\"activityId\":100003912,\"activityJoinUser\":0,\"activityLabel\":\"限时购活动\",\"activityPrice\":7000,\"activityStartTime\":1611158400000,\"activityStatus\":1,\"activityTypes\":0,\"appPrice\":7000,\"category\":\"数码影音\",\"categoryId\":151301,\"categoryName\":\"数码影音-电子教育-笔类\",\"channel\":1,\"createTime\":\"2021-01-20 11:11:21\",\"description\":\"\",\"details\":\"[{\\\"data\\\":1611025136,\\\"image\\\":\\\"https://staticimg.ngmm365.com/89eab39f211a8f7e877b83f4ec0fcc96-w200_h200.png\\\",\\\"title\\\":\\\"设置链接到页面地址\\\",\\\"type\\\":\\\"NULL\\\"}]\",\"existSku\":true,\"extProperties\":{\"memberRebate\":\"\",\"image\":\"\",\"urls\":\"{\\\"app\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"Link\\\"}},\\\"wxapp\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"MINIPROGRAM_LINK\\\"}},\\\"h5\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"Link\\\"}}}\",\"videoUrl\":\"\",\"channel\":\"1\",\"firstUpTime\":\"2021-01-19 10:59:58\",\"goodsDescAttrsSwitch\":\"false\",\"goodsDescAttrs\":\"[{\\\"name\\\":\\\"\\\",\\\"value\\\":\\\"\\\"}]\",\"isNew\":\"1\",\"searchKeyword\":\"\",\"memberDiscount\":\"10000\",\"selfFlag\":\"0\"},\"extension\":\"{\\\"memberRebate\\\":\\\"\\\",\\\"image\\\":\\\"\\\",\\\"urls\\\":{\\\"app\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"Link\\\"}},\\\"wxapp\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"MINIPROGRAM_LINK\\\"}},\\\"h5\\\":{\\\"isCheck\\\":false,\\\"url\\\":{\\\"data\\\":\\\"\\\",\\\"type\\\":\\\"Link\\\"}}},\\\"videoUrl\\\":\\\"\\\",\\\"channel\\\":1,\\\"firstUpTime\\\":\\\"2021-01-19 10:59:58\\\",\\\"goodsDescAttrsSwitch\\\":false,\\\"goodsDescAttrs\\\":[{\\\"name\\\":\\\"\\\",\\\"value\\\":\\\"\\\"}],\\\"isNew\\\":1,\\\"searchKeyword\\\":\\\"\\\",\\\"memberDiscount\\\":\\\"10000\\\",\\\"selfFlag\\\":0}\",\"forbidUseCampaign\":0,\"forbidUseCoupon\":1,\"goodsExtends\":{\"TIMELIMIT_ACTIVITY_V1\":{}},\"goodsMallVO\":{\"appId\":\"wxe1512eeb9ff270d6\",\"id\":1,\"name\":\"瓜瓜辅食小小娃\"},\"goodsPropVos\":[{\"optionNames\":[\"大于包邮\",\"小于包邮\",\"活动小于包邮\"],\"propName\":\"台\",\"propOrderNo\":0}],\"groupBuy\":1,\"haitao\":false,\"hiddenOnSaleTime\":1,\"id\":74609,\"isMakeUp\":0,\"isMemberGoods\":false,\"isShield\":0,\"lockStock\":0,\"mallId\":1,\"name\":\"限时购-商品-zh\",\"oldUserAppPrice\":7000,\"originSellPrice\":8000,\"originalPrice\":10000,\"pictures\":[\"https://staticimg.ngmm365.com/abf0999a81c96de500d838b66c86ff58-w200_h200.png\"],\"postage\":1000,\"priceMap\":{\"oldUserAppPrice\":7000,\"memberPrice\":0,\"originSellPrice\":8000,\"newUserAppPrice\":7000},\"restriction\":0,\"sales\":0,\"secKill\":true,\"selfFlag\":0,\"sellPrice\":7000,\"sellerCode\":\"zh1219002\",\"skus\":[{\"activityPrice\":7000,\"appPrice\":7000,\"goodsId\":74609,\"inclusiveTax\":0,\"oldUserAppPrice\":7000,\"optionCode\":\"小于包邮\",\"originSellPrice\":8000,\"price\":7000,\"priceMap\":{\"oldUserAppPrice\":7000,\"memberPrice\":0,\"originSellPrice\":8000,\"newUserAppPrice\":7000},\"sales\":0,\"sellerCode\":\"zh12190051\",\"skuId\":181248,\"skusExtends\":{},\"stock\":100,\"taxLevel\":1,\"weight\":1}],\"status\":1,\"stock\":300,\"subName\":\"\",\"syncStock\":0,\"testStatus\":0,\"v\":1,\"virtual\":false}]";

        System.out.println(s);
    }

    @Test
    public void test_volatile(){

    }

    public static Date dayEnd(Date date){
        LocalDate localDate = toLocalDate(date);
        LocalDateTime dateTime = localDate.atTime(23, 59, 59);

        long mills = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date endTime = new Date(mills);

        return endTime;
    }

    public static Date dayBegin(Date date){
        LocalDate localDate = toLocalDate(date);
        LocalDateTime dateTime = localDate.atTime(0, 0, 0);

        long mills = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date startTime = new Date(mills);

        return startTime;
    }

    private static LocalDate toLocalDate(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.toLocalDate();
    }

    public static void main(String[] args) {
        System.out.println(dayBegin(new Date()));
        System.out.println(dayEnd(new Date()));
    }


}
