package com.jcohy.study.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/5 11:21.
 * ClassName  : DateUtils
 * Description  :
 */
public class DateUtils {

    /** 年-月-日 时:分:秒 显示格式 */
    // 备注:如果使用大写HH标识使用24小时显示格式,如果使用小写hh就表示使用12小时制格式。
    private static String[] dateTimeReg = {
            "\\s*\\d{1,4}-\\d{1,2}-\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}\\s*",
            "\\s*\\d{1,4}-\\d{1,2}-\\d{1,2}\\s+\\d{1,2}:\\d{1,2}\\s*",
            "\\s*\\d{1,4}-\\d{1,2}-\\d{1,2}\\s+\\d{1,2}\\s*",
            "\\s*\\d{1,4}-\\d{1,2}-\\d{1,2}\\s*",
            "\\s*\\d{1,4}/\\d{1,2}/\\d{1,2}\\s+\\d{1,2}:\\d{1,2}:\\d{1,2}\\s*",
            "\\s*\\d{1,4}/\\d{1,2}/\\d{1,2}\\s+\\d{1,2}:\\d{1,2}\\s*",
            "\\s*\\d{1,4}/\\d{1,2}/\\d{1,2}\\s+\\d{1,2}\\s*",
            "\\s*\\d{1,4}/\\d{1,2}/\\d{1,2}\\s*"
    };
    //多种日期格式
    private static DateFormat[] dateFormat = {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyy-MM-dd HH:mm"),
            new SimpleDateFormat("yyyy-MM-dd HH"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
            new SimpleDateFormat("yyyy/MM/dd HH:mm"),
            new SimpleDateFormat("yyyy/MM/dd HH"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'"),
            new SimpleDateFormat("yyyyMMdd")
    };


    /**
     *  获取当前时间
     * @return
     */
    public static Date getDate(){
        return new Date();
    }
    /**
     * 检查两个时间是否是同一天
     * Mar 2002 13:45 and 28 Mar 2002 06:01 would return true.
     * 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * @param date1 时间1
     * @param date2 时间2
     * @return 如果代表同一天 返回true
     */
    public static boolean isSameDate(Date date1,Date date2){
        if(date1 == null || date2 == null){
            throw new IllegalArgumentException("The date must not be null");
        }
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * 检查两个时间是否是同一天
     * Mar 2002 13:45 and 28 Mar 2002 06:01 would return true.
     * 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * @param cal1 时间1
     * @param cal2 时间2
     * @return 如果代表同一天 返回true
     */
    public static boolean isSameDay(Calendar cal1,Calendar cal2){
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 检查两个时间是否是同一时间
     * @param date1 时间1
     * @param date2 时间2
     * @return 如果代表同一毫秒 返回true
     */
    public static boolean isSameInstant(final Date date1, final Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date1.getTime() == date2.getTime();
    }

    /**
     * 检查两个时间是否是同一时间
     * @param cal1 时间1
     * @param cal2 时间2
     * @return 如果代表同一毫秒 返回true
     */
    public static boolean isSameInstant(final Calendar cal1, final Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return cal1.getTime().getTime() == cal2.getTime().getTime();
    }


    /**
     * 检查两个时间是否代表同一时区时间
     * @param cal1 时间1
     * @param cal2 时间2
     * @return result
     */
    public static boolean isSameLocalTime(final Calendar cal1, final Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return cal1.get(Calendar.MILLISECOND) == cal2.get(Calendar.MILLISECOND) &&
                cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND) &&
                cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE) &&
                cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.getClass() == cal2.getClass();
    }


    /**
     * @param date 日期
     * @return result
     */
    private static boolean validateDateNotNull(final Date date) {
        if( date != null){
            return true;
        }else{
            throw new IllegalArgumentException("The date must not be null");
        }
    }


    //Converts
    //-----------------------------------------------------------------------
    /**
     * 获取待匹配的字符串对应的正则表达式的下标 index
     * @param dateStr 日期字符串
     * @return result
     */
    public static int getRegIndex(String dateStr){
        Pattern pattern = null;
        int i=0;
        for (; i<dateTimeReg.length; i++) {
            //compile(正则表达式)
            pattern = Pattern.compile(dateTimeReg[i]);

            //matcher(预匹配的字符串)
            Matcher mat = pattern.matcher(dateStr);

            //find() 是否匹配成功
            boolean isMatch = mat.find();
            if (isMatch){
                break;
            }

        }
        return i;
    }

    /**
     * date转换成calendar
     * @param date 时间
     * @return calendar
     */
    public static Calendar toCalendar(final Date date) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * date转换成calendar
     * @param date 时间
     * @param tz 时区
     * @return calendar
     */
    public static Calendar toCalendar(final Date date, final TimeZone tz) {
        final Calendar c = Calendar.getInstance(tz);
        c.setTime(date);
        return c;
    }

    /**
     * 时区转换
     * @param millions 毫秒数
     * @param tz 时区
     * @return result
     */
    public static String convertTimeZone(long millions,TimeZone tz){
        Date date = new Date(millions);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(tz);
        return sdf.format(date);
    }

    /**
     * 字符串转日期类:可以转换多种格式的字符串日期
     * @param dateStr 日期字符串
     * @return result
     */
    public static Date strToDate(String dateStr){
        if (dateStr==null || dateStr=="") {
            return null;
        }
        //匹配成功:那么那个i就是我们所需的，目的是为了可以从  dateFormat 取到需要转换为指定的时间格式
        int i=getRegIndex(dateStr.trim());

        Date resultDate=null;
        if (i<dateTimeReg.length) {
            try {
                resultDate=dateFormat[i].parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return resultDate;
    }

    /**
     * 日期转字符串
     * @param paramDate 日期
     * @param dateFormat 日期格式
     * @return result
     */
    public static String dateToStr(Date paramDate,String dateFormat){
        if (paramDate == null || dateFormat == null || dateFormat == "") {
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        return sdf.format(paramDate);
    }



    //gets
    //-----------------------------------------------------------------------
    /**
     * 获取当前月的第一天: 采用Calendar类实现
     * @return result
     */
    public static Date getFirstDayInMonth(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获得系统当前的时间: 可用于命名一些文件,如上传的图片
     * @return result
     * @throws Exception 系统异常
     */
    public static String getCurrentDateStr()throws Exception{
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 获取日期之间的天数
     * @param d1 时间1
     * @param d2 时间2
     * @return result
     */
    public static int getDaysBetween(Calendar d1, Calendar d2) {
        // swap dates so that d1 is start and d2 is end
        if (d1.after(d2)) {
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR)
                - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 获取工作日
     * @param d1 时间1
     * @param d2 时间2
     * @return result
     */
    public static int getWorkingDay(Calendar d1, Calendar d2) {
        int result = -1;
        // swap dates so that d1 is start and d2 is end
        if (d1.after(d2)) {
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        // int betweendays = getDaysBetween(d1, d2);
        // int charge_date = 0;
        int charge_start_date = 0;// 开始日期的日期偏移量
        int charge_end_date = 0;// 结束日期的日期偏移量
        // 日期不在同一个日期内
        int stmp;
        int etmp;
        stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
        etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);
        if (stmp != 0 && stmp != 6) {// 开始日期为星期六和星期日时偏移量为0
            charge_start_date = stmp - 1;
        }
        if (etmp != 0 && etmp != 6) {// 结束日期为星期六和星期日时偏移量为0
            charge_end_date = etmp - 1;
        }
        // }
        result = (getDaysBetween(getNextMonday(d1), getNextMonday(d2)) / 7)
                * 5 + charge_start_date - charge_end_date;
        return result;
    }

    /**
     * 获取中文日期
     * @param date 日期
     * @return result
     */
    public static String getChineseWeek(Calendar date) {
        final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        // System.out.println(dayNames[dayOfWeek - 1]);
        return dayNames[dayOfWeek - 1];
    }

    /**
     * 获得日期的下一个星期一的日期
     * @param date
     * @return
     */
    private static Calendar getNextMonday(Calendar date) {
        Calendar result = null;
        result = date;
        do {
            result = (Calendar) result.clone();
            result.add(Calendar.DATE, 1);
        } while (result.get(Calendar.DAY_OF_WEEK) != 2);
        return result;
    }

    /**
     * 获取休息日
     * @param d1 时间1
     * @param d2 时间2
     * @return result
     */
    public static int getHolidays(Calendar d1, Calendar d2) {
        return getDaysBetween(d1, d2) - getWorkingDay(d1, d2);
    }

    /**
     * 获取过去的天数
     * @param date 时间
     * @return result
     */
    public static long getPastDays(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(24*60*60*1000);
    }

    /**
     * 获取过去的小时
     * @param date 时间
     * @return result
     */
    public static long getPastHour(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(60*60*1000);
    }

    /**
     * 获取过去的分钟
     * @param date 时间
     * @return result
     */
    public static long getPastMinutes(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(60*1000);
    }

    /**
     * 获取过去的秒
     * @param date 时间
     * @return result
     */
    public static long getPastSeconds(Date date) {
        long t = System.currentTimeMillis()-date.getTime();
        return t/(1000);
    }

    /**
     *
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author fy.zhang
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " 天 " + hours + " 小时 " + minutes + " 分钟 "
                + seconds + " 秒 ";
    }
    /**
     *
     * @param begin 时间段的开始
     * @param end   时间段的结束
     * @return  输入的两个Date类型数据之间的时间间格用* days * hours * minutes * seconds的格式展示
     * @author fy.zhang
     */
    public static String formatDuring(Date begin, Date end) {
        return formatDuring(end.getTime() - begin.getTime());
    }

    public static Long stringToDate(String date) {
        //小写的mm表示的是分钟
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Long starTime= null;
        try {
            starTime = sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return starTime;
    }

}
