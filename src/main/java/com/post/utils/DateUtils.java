
package com.post.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
* @Title:日期工具类  
* @Description: TODO(描述)
* @author: 雷大鹏  
* @date: 2020-05-10 10:19:37
 */
public class DateUtils {

	// 获取今日日期
	public static String getToday() {
		return getToday("YYYY-MM-dd");
	}

	// 根据格式获取今日日期
	public static String getToday(String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(new Date());
	}

	// 判断传入日期是否为今日
	public static boolean isToday(Date date) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE));
		Date currentDay = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		return format.format(currentDay).equals(format.format(date));
	}

	// 根据格式获取昨天日期
	public static String getYesterDay(String formatStr) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
		Date yesterDay = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(yesterDay);
	}

	// 获取昨天日期
	public static String getYesterDay() {
		return getYesterDay("YYYY-MM-dd");
	}

	// 根据格式获取明天日期
	public static String getTomorrowDay(String formatStr) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
		Date yesterDay = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(yesterDay);
	}

	// 获取昨天日期
	public static String getTomorrowDay() {
		return getTomorrowDay("YYYY-MM-dd");
	}

	// 根据格式获取指定天数之前的日期
	public static String getBeforeDay(int days, String formatStr) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) - days);
		Date yesterDay = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(yesterDay);
	}

	// 根据格式获取指定天数之后的日期
	public static String getAfterDay(int days, String formatStr) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
		Date yesterDay = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(yesterDay);
	}

	// 获取当前处于第几季度
	public static int getQuarter() {
		Calendar c = Calendar.getInstance();
		int month = c.get(c.MONTH) + 1;
		int quarter = 0;
		if (month >= 1 && month <= 3) {
			quarter = 1;
		} else if (month >= 4 && month <= 6) {
			quarter = 2;
		} else if (month >= 7 && month <= 9) {
			quarter = 3;
		} else {
			quarter = 4;
		}
		return quarter;

	}

	// 获取量日期之间相隔天数
	public static int getBetweenDay(Date startDate, Date endDate) {
		Calendar d1 = new GregorianCalendar();
		d1.setTime(startDate);
		Calendar d2 = new GregorianCalendar();
		d2.setTime(endDate);
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		System.out.println("days=" + days);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	// 获取当前星期
	public static String getCurrentWeek() {
		return getWeekOfDate(new Date());
	}

	// 获取指定日期星期
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	public static Date getDate(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(sdf.format(date));
	}

	public static String getDateStr(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date getDate(Date date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(sdf.format(date));
	}

	public static Date getDate(String dateStr, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}

	public static String getDateStr(Date date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getDateNoYearStr(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}

	public static String getConsumingString(Long startTime, Long endTime) throws ParseException {

		Long consuming = endTime - startTime;

		return getConsumingString(consuming);
	}

	public static String getConsumingString(Long consuming) throws ParseException {

		int s = 1000;
		int m = s * 60;
		int h = m * 60;
		int d = h * 24;

		int d_ = 0;
		int h_ = 0;
		int m_ = 0;
		int s_ = 0;
		// 天
		if (consuming > d) {
			d_ = consuming.intValue() / d;
		}

		if (consuming - d_ * d > h) {
			h_ = (consuming.intValue() - d_ * d) / h;
		}

		if (consuming - d_ * d - h_ * h > m) {
			m_ = (consuming.intValue() - d_ * d - h_ * h) / m;
		}

		if (consuming - d_ * d - h_ * h - m_ * m > s) {
			s_ = (consuming.intValue() - d_ * d - h_ * h - m_ * m) / s;
		}

		String text = "";
		if (d_ != 0) {
			text += d_ + "天";
		}
		if (h_ != 0) {
			text += h_ + "小时";
		}
		if (m_ != 0) {
			text += m_ + "分钟";
		}

		if (s_ != 0) {
			text += s_ + "秒";
		}
		if (StringUtils.isBlank(text)) {
			text = consuming + "毫秒";
		}
		// System.out.println("耗时:" + text);
		return text;
	}

	public static void main(String[] args) {
		try {
			getConsumingString(0L, 800003300L);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
