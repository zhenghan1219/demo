package com.zzh.exercise.dateDemo;

import com.zzh.exercise.tencent.TencentAdFieldConstant;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:  LocalDate
 * @Date: Create by 2020/9/30
 */
public class DateTransform {

    public static void main(String[] args) {
        //checkImportDate();
        //lastWeek();sout
        System.out.println(beginDay(LocalDate.now()));
        //System.out.println();
        //localTimeSimple();
        nowHour();
    }

    /**
     *  返回当前时间的年月日
     * @return yyyy-MM-dd
     */
    public  LocalDate  getNowDate(){
        LocalDate date = LocalDate.now();
        return date;
    }

    /**
     *
     */
    public static  void dealSpecialDate(){
        LocalDate date = LocalDate.now();
        System.out.println("now date:"+date);
        LocalDate transDate = LocalDate.of(2020,9,30);
        System.out.println("transform date:"+transDate);
        //LocalDate中增加了equal方法，可以判断两个时间是否相等，
        //底层是使用两个时间相减来判断是否相等，使用LocalDate.year,month,day来获取int类型
        System.out.println("两个时间是否相等："+date.equals(transDate));

    }

    /**
     * 判断一个节日是否为重要节日，比如生日等周期性事件，使用MonthDay这个类，组合了月和日，可以判断每年发生的事情
     * MonthDay和YearDay都是不可变并且线程安全的。
     */
    public static void checkImportDate(){
        LocalDate date = LocalDate.now();
        LocalDate transDate = LocalDate.of(2020,9,29);
        MonthDay birthDay=  MonthDay.of(transDate.getMonth(),transDate.getDayOfMonth());
        MonthDay currentDay = MonthDay.from(date);
        if (currentDay.equals(birthDay)){
            System.out.println(currentDay);
            System.out.println("happy birthday for u and now time is :"+LocalTime.now()+"--"+birthDay);
        }else {
            System.out.println(currentDay);
            System.out.println("today is not your birthday and now time is :"+LocalTime.now()+"and your birthday is :"+birthDay);
        }
    }

    public static void localTimeSimple(){
        //获取当前时间 hh:mm:ss:nnn
        LocalTime time = LocalTime.now();  //nnn为六位
        System.out.println("now time is:"+time);
        LocalTime addTwoHour = time.plusHours(2);
        System.out.println("add two hour:"+addTwoHour);
    }

    public static  void lastWeek(){
        LocalDate date = LocalDate.now();
        System.out.println("now date:"+date);
        //计算几周后的日期。1代表一周后，2代表两周后等。
        //也可以使用ChronoUnit.Years等来查看一年，一月，一时，一分钟甚至是一世纪
        date.minus(1,ChronoUnit.YEARS);
        LocalDate plusDate = date.plus(2, ChronoUnit.WEEKS);
        System.out.println("ChronoUnit:"+ChronoUnit.WEEKS);

    }

    public static void transJson(){
        String var = "vars";
        var.intern();
        //DateTransform::lastWeek();
    }

    public static String beginDay(LocalDate time){
        return LocalDateTime.of(time,LocalTime.MIN).format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss"));


    }

    public String endDay(LocalDate time){
        return LocalDateTime.of(time,LocalTime.MAX).format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss"));
    }
    /**
     * 获取当前的小时
     */
    public static  void nowHour(){
        //LocalTime localTime = LocalTime.of(12,35,59);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
    }

    /**
     * 判断是否为前一天
     */
    public static boolean nowIsBeforeDay(LocalTime localTime){
        int hour = localTime.getHour();
        if (hour < 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     *  获取前一天的日期
     * @return
     */
    public static String beforeOneDayNowDate(){
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.minusDays(1);
        return localDate.toString();
    }
    /**
     *  获取前两天的日期
     * @return
     */
    public static String beforeTwoDayNowDate(){
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.minusDays(2);
        return localDate.toString();
    }

    @Test
    public void testNowIsBeforeDay(){
        LocalTime now = LocalTime.now();
        boolean b = nowIsBeforeDay(now);
        System.out.println("当前时间不是前一天："+b);
        LocalTime localTime = LocalTime.of(0,59,59);
        boolean b1 = nowIsBeforeDay(localTime);
        System.out.println("当前时间是前一天："+b1);
    }

    @Test
    public void testBeforeOneDayNowDate(){
        System.out.println(beforeOneDayNowDate());
        System.out.println(beforeTwoDayNowDate());
    }


    /**
     *
     */
    @Test
    public void testBefore(){
        Date date = DateUtils.addDays(new Date(), -1);
        System.out.println(date);
    }

}
