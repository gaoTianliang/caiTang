package com.code.core.base.date;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static void main(String[] args) {
        Date now = new Date();
        //获得当前时间之前的5天
        Date date = DateUtils.addDays(now, -5);
        //格式化为String
        String format = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");


        System.out.println(format);

    }

    /**
     * 输出两个日期和两个日期之间的日期
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getBetweenDates(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse(startDate);
            end = sdf.parse(endDate);
        } catch (ParseException var8) {
            var8.printStackTrace();
        }
        List<String> result = new ArrayList();
        result.add(startDate);
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(6, 1);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(6, 1);
        }
        result.add(endDate);
        return result;
    }

    /**
     * 获得指定时间所在周的第一天和最后一天
     *
     * @param dateStr          指定的时间
     * @param dateFormat       指定的时间格式
     * @param resultDateFormat 输出的时间格式
     * @return startTime:"",endTime:""
     * @throws ParseException
     */
    public static Map<String, Object> getFirstAndLastOfWeek(String dateStr, String dateFormat,
                                                            String resultDateFormat) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime((new SimpleDateFormat(dateFormat)).parse(dateStr));
        int d;
        if (cal.get(7) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(7);
        }
        cal.add(7, d);
        String data1 = (new SimpleDateFormat(resultDateFormat)).format(cal.getTime());
        cal.add(7, 6);
        String data2 = (new SimpleDateFormat(resultDateFormat)).format(cal.getTime());
        Map<String, Object> map = Maps.newHashMap();
        map.put("startTime", data1);
        map.put("endTime", data2);
        return map;
    }

    /**
     * 获得date所在月份的天数
     *
     * @param date
     * @return
     */
    public static int getDaysByYearMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Calendar a = Calendar.getInstance();
        a.set(1, cal.get(1));
        a.set(2, cal.get(2));
        a.set(5, 1);
        a.roll(5, -1);
        return a.get(5);
    }

    /**
     * 检查after比before过来多长时间
     *
     * @param before
     * @param after
     * @param select 1：天，2：小时，3：分钟
     * @return
     */
    public static long pastDays(Date before, Date after, int select) {
        long t = after.getTime() - before.getTime();
        switch (select) {
            case 1:
                return t / 86400000L;
            case 2:
                return t / 3600000L;
            default:
                return t / 60000L;
        }
    }

    /**
     * 判断before和after之间间隔了多少天
     *
     * @param before
     * @param after
     * @return after-before 天数
     */
    public static int intervalDays(Date before, Date after) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(before);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(after);
        int day1 = cal1.get(6);
        int day2 = cal2.get(6);
        int year1 = cal1.get(1);
        int year2 = cal2.get(1);
        if (year1 == year2) {
            return day2 - day1;
        } else {
            int timeDistance = 0;
            for (int i = year1; i < year2; ++i) {
                if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                    timeDistance += 365;
                } else {
                    timeDistance += 366;
                }
            }
            return timeDistance + (day2 - day1);
        }
    }
}
