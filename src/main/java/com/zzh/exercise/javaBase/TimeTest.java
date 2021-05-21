package com.zzh.exercise.javaBase;

import com.zzh.exercise.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/21
 */
public class TimeTest {
    private static  String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
    private static final String YYYY_MM_DD = "yyyy_MM_dd";
    @Test
    public void testNow(){
        //LocalTime now = LocalTime.now();
        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());
        System.out.println(System.currentTimeMillis());
       // 1000 * 60 * 15 = 900000;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date afterDate = new Date(now .getTime() + 300000);
        System.out.println(sdf.format(afterDate ));

    }


    @Test
    public void testString(){
        Student s = new Student();
        s.setName("a");
        s.setAge(10);
        List<Student> list = new ArrayList<>();
        Student stu = new Student();
        stu.setName("a");
        stu.setAge(10);
        stu.setGarde("1");
        Map<String ,Student> map = new HashMap<>();
        //map.put("a",stu);
        list.forEach(result ->{
            String name = result.getName();
            if(StringUtils.isNotEmpty(name) && map.containsKey(name)){
                //如果map中包含该key
                System.out.println(map.get(name));
            }
        });

    }


    @Test
    public void testYearAndMonth() throws ParseException {
        Date startTime =new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date endTime = simpleDateFormat.parse("2021-03-01 12:11:11");
        long time = startTime.getTime();
        long time1 = endTime.getTime();


        if (startTime.getMonth() != endTime.getMonth()){
            System.out.println("不是同一个月");
        }
        long l = time1 - time;
        long sevenDay = 7*24*60*60*1000;
        long thirtyDay = 30*24*60*60*1000;
        if(l > sevenDay){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    /**
     * date转datetime
     * @param date
     * @return
     */
    public static LocalDateTime toDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }

    @Test
    public void testMillion() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endTime = simpleDateFormat.parse("2021-03-01");

        LocalDate localDate = endTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDateTime endTime1 = LocalDateTime.of(localDate, LocalTime.MAX);
        long l = endTime1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date ent = new Date(l);
        System.out.println(ent);
    }

    @Test
    public void testLongTransDate(){
        System.out.println(new Date(1615048026000l));
        System.out.println(new Date(1615103321000l));
    }

    @Test
    public void testMonth() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endTime = simpleDateFormat.parse("2021-03-01");
        Date startTime = simpleDateFormat.parse("2020-03-01");
        final LocalDate startDate = toLocalDate(startTime);
        final LocalDate endDate = toLocalDate(endTime);
        System.out.println(startDate.getMonthValue() == endDate.getMonthValue());
        System.out.println(endTime.getMonth() == startTime.getMonth());
    }

    public static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Test
    public void test_sameDay() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date endTime = simpleDateFormat.parse("2021-05-20 05:42:12");
        if(DateUtils.isSameDay(date,endTime)){
            System.out.println("是同一天");
        }else {
            System.out.println("不是");
        }



    }
}
