package com.cscrb.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

    public static final String datePattern = "yyyy-MM-dd";
    public static final String datePattern1 = "yyyyMMddHHmmss";
    public static final String datePattern2 = "MMddHHmmss";
    public static final String dateCnPattern = "yyyy年MM月dd日HH时mm分";

    public static void main(String[] args) {
//		System.out.println(getBeforeDay(1,"yyyy-MM-dd"));
        //System.out.println(compareStrDate("2017-8-24",new Date(),"yyyy-MM-dd"));
        //System.out.println(getAssignedTime("hour"));
        System.out.println(getBeforeDayStr(6));
        //System.out.println(dateFormatNow(null));
    }

    /**
     * 是否包含今天
     */
    public static boolean isToday(String start, String end) {
        if (start == null && end == null) {
            return true;
        }
        if (start == "" && end == "") {
            return true;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        Date now = null;
        String nowStr = sdf.format(new Date());
        try {
            startDate = sdf.parse(start);
            endDate = sdf.parse(end);
            now = sdf.parse(nowStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (now.getTime() >= startDate.getTime() && now.getTime() <= endDate.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    public static long getTime(String str) {
        long time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (str == null) {
                String nowStr = sdf.format(new Date());
                time = sdf.parse(nowStr).getTime();
            } else {
                time = sdf.parse(str).getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }

    public static long getTimeSecond(String str) {
        long time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (str == null) {
                String nowStr = sdf.format(new Date());
                time = sdf.parse(nowStr).getTime();
            } else {
                time = sdf.parse(str).getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String formatBirthday(String dateString) {
        if (dateString == null) return null;

        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern, Locale.UK);
        SimpleDateFormat df2 = new SimpleDateFormat("MM-dd", Locale.UK);

        try {
            Date date = df.parse(dateString);
            return df2.format(date);
        } catch (ParseException e) {
            //throw new RuntimeException(e);
            return null;
        }
    }

    public static String getTime(Date date, String timePattern) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timePattern);
        return simpleDateFormat.format(date);
    }

    public static Date thisYearBirthday(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        try {
            Date date = sdf.parse(birthday);
            date.setYear(new Date().getYear());
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算日期相差几天
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

        return day2 - day1;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return date
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = null;
        try {
            str = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Date StrToDate1(String str) {
        Date date = null;
        if (StringUtils.isBlank(str)) {
            return new Date();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StrToDate2(String str) {
        Date date = null;
        if (StringUtils.isBlank(str)) {
            return new Date();
        }
        SimpleDateFormat format = new SimpleDateFormat("HHmmss");

        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String StrDateFormat(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = "";
        Date date = null;
        if (StringUtils.isBlank(str)) {
            return format2.format(new Date());
        }
        try {
            date = format.parse(str);
            strDate = format2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }


    /**
     * 字符串转换成日期（原始为日期）
     *
     * @param str
     * @return date
     */
    public static Date StrDateToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StrDateToDate1(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换成日期字符串
     *
     * @param str
     * @return date
     */
    public static String StrToDateStr(String str, String datePattern) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (datePattern == null) datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern, Locale.UK);
        return df.format(date);
    }

    public static String StrToDatePatternStr(String str, String datePattern) {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (datePattern == null) datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern, Locale.UK);
        return df.format(date);
    }

    public static String StrToDateStrV2(String str, String datePattern, String datePattern1) {

        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat df = new SimpleDateFormat(datePattern1, Locale.UK);
        return df.format(date);
    }

    public static Date strToDate(String str, String datePattern) {
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getBirthdayAfterDays(int days) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        return sdf.format(cal.getTime());
    }

    public static String dateFormat(Date date, String datePattern) {
        if (date == null) return "";
        if (datePattern == null) datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern, Locale.UK);
        return df.format(date);
    }


    public static String dateFormatNow(String datePattern) {
        if (datePattern == null) datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern, Locale.UK);
        return df.format(new Date());
    }

    /**
     * 精确到秒
     *
     * @param datePattern
     * @return
     */
    public static Date dateFormatNowV2(String datePattern) {
        if (datePattern == null) datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern, Locale.UK);
        String formatStr = df.format(new Date());
        try {
            return df.parse(formatStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getBeforeday(Date date, int day) {
        if (date == null) date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - day);

        return calendar.getTime();
    }

    public static Date getLately(Date date, int day) {
        if (date == null) date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);

        return calendar.getTime();
    }

    public static String getBeforeday(Date date, int day, String datePattern) {
        if (date == null) date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - day);
        date = calendar.getTime();
        if (datePattern == null) datePattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(datePattern);

        return df.format(date);
    }

    public static Date getAfterMonth(int month) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);

        return now.getTime();
    }

    public static Date getBeforMonth(int month) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);

        return now.getTime();
    }

    public static String getBeforMonth(int month, String datePattern) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return format.format(now.getTime());
    }

    public static String getBeforMonthFirstDay(int month, String datePattern) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
        now.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return format.format(now.getTime());
    }

    public static String getBeforMonthLastDay(int month, String datePattern) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
        now.set(Calendar.DAY_OF_MONTH, 0);
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return format.format(now.getTime());
    }

    public static Date getAfterDay(int day) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) + day);

        return now.getTime();
    }

    public static Date getBeforeDay(int day) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) - day);

        return now.getTime();
    }

    public static String getBeforeDayStr(int day) {
        Date beforeDate = getBeforeDay(day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(beforeDate);
    }

    public static String getAfterDayStr(int day) {
        Date beforeDate = getAfterDay(day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(beforeDate);
    }

    public static String getBeforeDay(int day, String datePattern) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) - day);

        SimpleDateFormat format = new SimpleDateFormat(datePattern);

        return format.format(now.getTime());
    }

    public static Date getAfterMinute(int minute) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);

        return now.getTime();
    }

    public static Date getAfterMinute(Date date, int minute) {
        Date d = date;
        if (d == null) d = new Date();

        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);

        return now.getTime();
    }

    public static Date getBeforeMinute(int minute) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) - minute);

        return now.getTime();
    }

    public static String getAfterHours(String strDate, int hours, String datePattern) {
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + hours);

        return format.format(calendar.getTime());
    }

    public static Date getBeforeHours(Date date, int hours) {
        if (date == null) date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR, now.get(Calendar.HOUR) - hours);
        return now.getTime();
    }

    public static Date getBeforeMinute(Date date, int minute) {
        if (date == null) date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) - minute);
        return now.getTime();
    }

    public static Date getAfterSecond(int Second) {
        Date d = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.SECOND, now.get(Calendar.SECOND) + Second);

        return now.getTime();
    }

    public static int getHours(Date start, Date end) {
        long time = end.getTime() - start.getTime();
        long hours = time / (1000 * 60 * 60);
        return (int) hours;
    }

    public static int compareDate(Date date, Date now) {
        String nowString = dateFormat(now, datePattern);
        String dateString = dateFormat(date, datePattern);

        Date nowDate = null, myDate = null;
        SimpleDateFormat myFormatter = new SimpleDateFormat(datePattern);

        try {
            nowDate = myFormatter.parse(nowString);
            myDate = myFormatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        int day = (int) ((myDate.getTime() - nowDate.getTime()) / (24 * 60 * 60 * 1000));
        return day;
    }

    public static int compare(Date date1, Date date2) {
        String date1String = dateFormat(date1, datePattern);
        String date2String = dateFormat(date2, datePattern);

        SimpleDateFormat myFormatter = new SimpleDateFormat(datePattern);

        try {
            date1 = myFormatter.parse(date1String);
            date2 = myFormatter.parse(date2String);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        int day = (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
        return day;
    }


    public static java.sql.Date toSqlDate(Calendar c) {
        return new java.sql.Date(c.getTimeInMillis());
    }

    public static Calendar getFirstDayOfWeek() {
        Calendar monday = Calendar.getInstance();
        return getADayOfWeek(monday, Calendar.MONDAY);
    }

    public static Calendar getFirstDayOfWeek(Calendar day) {
        Calendar monday = (Calendar) day.clone();
        return getADayOfWeek(monday, Calendar.MONDAY);
    }

    public static Calendar getLastDayOfWeek() {
        Calendar sunday = Calendar.getInstance();
        return getADayOfWeek(sunday, Calendar.SUNDAY);
    }

    public static Calendar getLastDayOfWeek(Calendar day) {
        Calendar sunday = (Calendar) day.clone();
        return getADayOfWeek(sunday, Calendar.SUNDAY);
    }

    private static Calendar getADayOfWeek(Calendar day, int dayOfWeek) {
        int week = day.get(Calendar.DAY_OF_WEEK);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        if (week == dayOfWeek)
            return day;
        int diffDay = dayOfWeek - week;
        if (week == Calendar.SUNDAY) {
            diffDay -= 7;
        } else if (dayOfWeek == Calendar.SUNDAY) {
            diffDay += 7;
        }
        day.add(Calendar.DATE, diffDay);

        return day;
    }

    /**
     * 得到本月的第一天
     *
     * @return
     */
    public static Date getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static Date getMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date nextDay(Date start) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * 格式化时间为yyyy-MM-dd 00:00:00
     */
    public static Date dayStartDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 格式化时间为yyyy-MM-dd 00:00:00
     */
    public static Date dayEndDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 格式化时间为yyyy-MM-dd 00:00:00
     */
    public static String dayEndDate(String dateStr) {
        Calendar c = Calendar.getInstance();

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        c.setTime(date);
        c.add(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date time = c.getTime();


        return sdf.format(time);
    }

    /**
     * 获得指定日期的后一天
     *
     * @param date
     * @return
     */
    public static String getTomorrowString(String date) {
        String str = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            str = sdf.format(nextDay(sdf.parse(date)));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay, int reduce) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - reduce);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }

    public static Date getSpecifiedDayBefore(Date date, int reduce) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        if (date == null) date = new Date();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - reduce);

        return c.getTime();
    }

    public static String getSpecifiedDayAfter(String specifiedDay, int reduce) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + reduce);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }

    public static String getSpecifiedDayAfterV2(Date date, int reduce, String datePattern) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + reduce);

        String dayBefore = new SimpleDateFormat(datePattern).format(c
                .getTime());
        return dayBefore;
    }

    /**
     * 订单生成时间
     *
     * @return
     */
    public static String getSystemTimeForStart() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern1);
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    public static String getSystemTimeForStart1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern2);
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    /**
     * 订单失效时间
     *
     * @return
     */
    public static String getSystemTimeForExpire() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern1);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static Date getFormatDate(Date date) {
        if (date == null) date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime = formatter.parse(dateString, pos);
        return currentTime;
    }

    /**
     * 判断是不是今天
     *
     * @param start
     * @param end
     * @return
     */
    public static boolean ifToday(String start, String end) {
        if (start == null && end == null) {
            return false;
        }
        if (end != null && end.length() != 0) end = DateUtils.getSpecifiedDayBefore(end, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        Date now = null;
        String nowStr = sdf.format(new Date());
        try {
            if (start != null && !"".equals(start)) {
                startDate = sdf.parse(start);
            }
            if (end != null && !"".equals(end)) {
                endDate = sdf.parse(end);
            }
            now = sdf.parse(nowStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long stime = null;
        Long eTime = null;
        if (startDate != null) {
            stime = startDate.getTime();
        }
        if (endDate != null) {
            eTime = endDate.getTime();
        }
        if (stime != null && eTime != null) {
            if (now.getTime() == stime && now.getTime() == eTime) {
                return true;
            } else {
                return false;
            }
        } else if (stime != null && eTime == null) {
            if (now.getTime() >= stime) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Date getMosaicDate(Date date, Time time) {
        SimpleDateFormat format1 = new SimpleDateFormat(datePattern);
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = format1.format(date);
        String str2 = format2.format(time);
        String mosaicStr = str1 + " " + str2;
        Date mosaicDate = null;
        try {
            mosaicDate = format3.parse(mosaicStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mosaicDate;
    }

    public static boolean compare(Date date, Date start, Date end) {
        long dateTime = date.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();
        if (dateTime >= startTime && dateTime < endTime) return true;
        return false;
    }

    public static String addDay(Date date, int n, String formatStr) {
        String d = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, n);
            d = format.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static String addMonth(Date date, int n) {
        String d = "";
        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, n);
            d = format.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static Date convertSTRTODate(String str) {
        Date d = new Date();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
            d = format2.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static String convertSTRDate(String str) {
        String str2 = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
            Date d = format2.parse(str);
            str2 = format.format(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static String convertSTRDateV2(String str) {
        String str2 = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
            Date d = format2.parse(str);
            str2 = format.format(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static Date getDateForStr(String str, String datePattern) {
        Date date = null;
        if (StringUtils.isEmpty(str)) return date;
        try {
            SimpleDateFormat format = new SimpleDateFormat(datePattern);
            return format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int compareStrDate(String date1, Date now, String format) {
        String nowString = dateFormat(now, format);
        Date nowDate = null, myDate = null;
        SimpleDateFormat myFormatter = new SimpleDateFormat(format);

        try {
            nowDate = myFormatter.parse(nowString);
            myDate = myFormatter.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        int day = (int) ((myDate.getTime() - nowDate.getTime()) / (24 * 60 * 60 * 1000));
        return day;
    }

    public static int getAssignedTime(String type) {
        int time = 0;
        Calendar cal = Calendar.getInstance();
        if (type.equals("year")) return cal.get(Calendar.YEAR);//获取年份
        if (type.equals("month")) return cal.get(Calendar.MONTH);//获取月份
        if (type.equals("date")) return cal.get(Calendar.DATE);//获取日
        if (type.equals("hour")) return cal.get(Calendar.HOUR_OF_DAY);//小时
        if (type.equals("minute")) return cal.get(Calendar.MINUTE);//分
        if (type.equals("second")) return cal.get(Calendar.SECOND);//秒
        if (type.equals("WeekOfYear")) return cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
        return time;
    }

    private static String getHour(int hour) {
        String str = String.valueOf(hour);
        if (str.length() < 2) str = "0" + str;
        return str;
    }

    public static Date geLastWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static Date getNextWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public static String getDateStr2(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }
}

