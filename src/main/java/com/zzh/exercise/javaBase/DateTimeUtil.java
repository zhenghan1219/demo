package com.zzh.exercise.javaBase;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class DateTimeUtil {

	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private final static DateTimeFormatter dtfs = DateTimeFormatter.ofPattern("yyyyMMdd");

	private final static DateTimeFormatter ymdhms = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String toString(Date date, DateTimeFormatter formatter) {
		return formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()));
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static String toYmdhms(Date date) {
		return toString(date, ymdhms);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss to mills
	 * @param dateStr
	 * @return
	 */
	public static Long toMills(String dateStr) {
		LocalDateTime parse = LocalDateTime.parse(dateStr, ymdhms);
		return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	/**
	 *
	 * @param localdatetime
	 * @return
	 */
	public static Date toDate(LocalDateTime localdatetime) {
		return new Date(localdatetime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
	}

	/**
	 * date转datetime
	 * @param date
	 * @return
	 */
	public static LocalDateTime toDateTime(Date date) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
	}

	public static String toYmdhmsOrNull(Date date) {
		if (Objects.isNull(date)) {
			return null;
		}
		return toString(date, ymdhms);
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
		return LocalDate.parse(day, dtf);
	}

	/**
     * yyyy-MM-dd 转换为 yyyyMMdd
	 * @return
     */
	@Test
	public void dateConvertion() {
		String str = "20200201";   //
		  //yyyy-MM-dd
		try {
			//   yyyyMMdd转yyyy-MM-dd
			Date format1 = null;
			format1 = new SimpleDateFormat("yyyyMMdd").parse(str);
			String longDate = new SimpleDateFormat("yyyy-MM-dd").format(format1);
			System.out.println("yyyyMMdd转yyyy-MM-dd:"+longDate);
			// yyyy-MM-dd转yyyyMMdd

		} catch (ParseException e) {
			//throw new BizException("转换异常");
		}
	}






}
