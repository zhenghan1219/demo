package com.zzh.exercise;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/10/15
 */
public class JsonTest {

    @Test
    public void transJson(){
        StringBuilder sb = new StringBuilder();
        //{
        //  "lable":"1",
        //  "value":"1"
        //}
        sb.append("[");
        for (int i = 1; i < 366; i++) {

            sb.append("{");
            sb.append("\"");
            sb.append("lable");
            sb.append("\"");
            sb.append(":");
            sb.append("\"");
            sb.append(i);
            sb.append("\"");
            sb.append(",");
            sb.append("\"");
            sb.append("value");
            sb.append("\"");
            sb.append(":");
            sb.append("\"");
            sb.append(i);
            sb.append("\"");
            sb.append("}");
            sb.append(",");

        }
        sb.append("]");
        System.out.println(sb);
        System.out.println(sb.length());

    }

    /**
     * 判断一个整数a是否为2的整次幂
     */
    @Test
    public void testMath(){
        int num = 4;
        System.out.println(isPowerOfTwo(num));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    @Test
    public void testAnd(){
        int cap =2 ;
        int a = 5;
        System.out.println(cap - 2 &  a);
    }

    @Test
    public void testA(){
        String s = "{\"flowDayBegin\": \"2021-03-01\",\"flowDayEnd\": \"2021-03-09\"}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);
    }

    @Test
    public void test_date(){
        Long a = 1614528000000l;
        Long b = 1614614399000l;
        System.out.println(new Date(a)+"_"+new Date(b));
    }

    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Date dayTransTimeStart(String  date){
        LocalDate localDate = strToDate(date);
        LocalDateTime dateTime = localDate.atTime(0, 0, 0);

        long mills = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date startTime = new Date(mills);

        return startTime;
    }

    private static LocalDate strToDate(String day) {
        return LocalDate.parse(day, dtf);
    }



    @Test
    public void test_oth(){
        String date="2019-01-12";
        System.out.println();
    }

    private static String StringToDate(String date) throws ParseException {
        String dateString = "";
        dateString = new SimpleDateFormat("yyyyMMdd").format(date);

        return dateString;
    }
}
