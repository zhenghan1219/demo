package com.zzh.exercise.javaBase;

/**

 */

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/3/18
 * @description V1.0 LocalDateTime工具类
 * SQL -> Java
 * date -> LocalDate
 * time -> LocalTime
 * timestamp -> LocalDateTime
 */
public class DateTimeUtils {

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
    public static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter LONG_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
    private final static Long thirtyDayTransMillion = 30*24*60*60*1000L;
    private final static Long sevenDayTransMillion = 7*24*60*60*1000L;

    /**
     * 返回当前的日期
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * yyyy-MM-dd
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * yyMMdd
     */
    public static String getCurrentShortDateStr() {
        return LocalDate.now().format(SHORT_DATE_FORMATTER);
    }

    public static String getCurrentMonthStr() {
        return LocalDate.now().format(YEAR_MONTH_FORMATTER);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }


    public static String getCurrentLongDateTimeStr(){
        return LocalDateTime.now().format(LONG_DATETIME_FORMATTER);
    }

    /**
     * yyMMddHHmmss
     */
    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
    }

    /**
     * HHmmss
     */
    public static String getCurrentTimeStr() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    public static String getCurrentDateStr(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentDateTimeStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentTimeStr(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalTime parseLocalTime(String timeStr, String pattern) {
        return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
    }




    public static String formatLocalDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDateTime(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalTime(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    public static LocalDateTime parseLongLocalDateTime(String longDateTimeStr){
        return LocalDateTime.parse(longDateTimeStr, LONG_DATETIME_FORMATTER);
    }


    public static String parseLocalTimeString(String timeStr){
        String format = LocalDate.parse(timeStr,DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(SHORT_DATE_FORMATTER);
        return format;
    }
    /**
     *  yyyy-MM-dd格式转换为Date格式的23:59:59
     * @param date
     * @return
     */
    public static Date dayTransTimeEnd(String date){
        LocalDate localDate = strToDate(date);
        LocalDateTime dateTime = localDate.atTime(23, 59, 59);

        long mills = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date endTime = new Date(mills);

        return endTime;
    }

    /**
     * yyyy-MM-dd格式转换为Date格式的00:00:00
     * @param date
     * @return
     */
    public static Date dayTransTimeStart(String  date){
        LocalDate localDate = strToDate(date);
        LocalDateTime dateTime = localDate.atTime(0, 0, 0);
        long mills = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date startTime = new Date(mills);
        return startTime;
    }

    private static LocalDate strToDate(String day) {
        return LocalDate.parse(day, DATE_FORMATTER);
    }


    public static boolean subDateBy30Day(String beginDate,String endDate){
        boolean flag = false;
        Date timeEnd = DateTimeUtils.dayTransTimeEnd(endDate);
        Date timeStart = DateTimeUtils.dayTransTimeStart(beginDate);
        long l = timeEnd.getTime() - timeStart.getTime();
        if(l >thirtyDayTransMillion ){
            flag = true;
        }
        return flag ;
    }

    /**
     * beginDate-endDate
     * 时间传入格式为yyyy-MM-dd
     * @param beginDate
     * @param endDate
     * @return boolean true 大于7天
     */
    private static boolean subDateBy7Day(String beginDate,String endDate){
        boolean flag = false;
        Date timeEnd = DateTimeUtils.dayTransTimeEnd(endDate);
        Date timeStart = DateTimeUtils.dayTransTimeStart(beginDate);

        long l = timeEnd.getTime() - timeStart.getTime();
        if(l >sevenDayTransMillion ){
            flag = true;
        }
        return flag ;
    }

    @Test
    public void test(){
        String s = DateTimeUtils.parseLocalTimeString("2110-12-12");
        System.out.println(s);

        boolean b = DateTimeUtils.subDateBy30Day("2021-01-01", "2021-02-01");
        System.out.println(b);
    }

    public static LocalTime parseLocalTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    public static String formatLocalDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static String formatLocalDateTime(LocalDateTime datetime) {
        return datetime.format(DATETIME_FORMATTER);
    }

    public static String formatLocalTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * 日期相隔秒
     */
    public static long periodHours(LocalDateTime startDateTime,LocalDateTime endDateTime){
        return Duration.between(startDateTime, endDateTime).get(ChronoUnit.SECONDS);
    }

    /**
     * 日期相隔天数
     */
    public static long periodDays(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    /**
     * 日期相隔周数
     */
    public static long periodWeeks(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.WEEKS);
    }

    /**
     * 日期相隔月数
     */
    public static long periodMonths(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.MONTHS);
    }

    /**
     * 日期相隔年数
     */
    public static long periodYears(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.YEARS);
    }

    /**
     * 是否当天
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }
    /**
     * 获取当前毫秒数
     */
    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 判断是否为闰年
     */
    public static boolean isLeapYear(LocalDate localDate){
        return localDate.isLeapYear();
    }

    public void test_dateUtils(){
        long l = DateUtils.MILLIS_PER_DAY * 30l;
    }

    private static boolean isCreateTimeBeforeOneMonth(String startTime,String endTime) {
        Date start = null;
        Date end = null;
        System.out.println(startTime.substring(5,7)+"--"+endTime.substring(5,7));
        if(!startTime.substring(5,7).equals(endTime.substring(5,7))){
            return true;
        }
        try {
            start = DateUtils.parseDate(startTime,"yyyy-MM-dd");
            end = DateUtils.parseDate(endTime,"yyyy-MM-dd");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return true;
        }

        Date after30Days = DateUtils.addDays(start, 7);
        return after30Days.before(end);
    }

    @Test
    public void test_month(){
        System.out.println(isCreateTimeBeforeOneMonth("2021-02-27","2021-03-01"));
    }

}
