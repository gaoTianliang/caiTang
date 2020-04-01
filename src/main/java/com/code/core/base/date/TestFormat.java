package com.code.core.base.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestFormat {

    /**
     * format yyyy-MM-dd HH:mm:ss
     */
    @Test
    public void test3() {
        Date pxsj = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = format1.format(pxsj); //3月8日
        System.out.println(time1);
    }

    /**
     * 查看时间的上午、下午
     */
    @Test
    public void test2() {
        Date date = new Date();
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(date);
        //结果为0是上午     为1是下午
        int i = ca.get(GregorianCalendar.AM_PM);
        System.out.println(ca.get(GregorianCalendar.AM_PM) == Calendar.PM ? "下午" : "上午");
    }

    /**
     * 查看时间的周几
     */
    @Test
    public void test1() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("EEEE");
        String format1 = format.format(date);
        System.out.println(format1);
    }
}
