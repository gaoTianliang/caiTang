package com.code.core.base.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Map;

/**
 * Java8日期新特性
 *
 * @author gaotianliang
 */
public class TestDate8 {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);//字符形式的当前时间
        System.out.println(format);

        Instant now2 = Instant.now();
        long l = now2.toEpochMilli();
        Date date = new Date(l);//Date类型的当前时间
        System.out.println(date.toString());
    }

    /**
     * 类似于year、month等数据
     */
    @Test
    public void testChronoField() {
        ChronoField milliOfDay = ChronoField.MILLI_OF_DAY;
        String s = milliOfDay.toString();
        System.out.println(s);
    }

    /**
     * 时区的设置
     */
    @Test
    public void testZoneOffSet() {
        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);//北京时间
        Instant now = Instant.now();
        OffsetDateTime offsetDateTime = now.atOffset(zoneOffset);
        String s = offsetDateTime.toString();
        System.out.println(s);
    }

    /**
     * 时间戳：从1970年1月1日 00：00：00开始的毫秒值
     */
    @Test
    public void testInstant() {
        Instant now = Instant.now();
        System.out.println(now.toEpochMilli());
    }

    /**
     * 简单日期
     */
    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        boolean after = localDate.isAfter(LocalDate.now());
        int dayOfYear = localDate.getDayOfYear();
        long aLong = localDate.getLong(ChronoField.MILLI_OF_DAY);
        LocalDate of = LocalDate.of(2019, 12, 25);
        LocalDate localDate1 = LocalDate.ofYearDay(2019, 258);
        LocalDate min = LocalDate.MIN;
        LocalDate ctt = LocalDate.now(ZoneId.of("CTT"));//带时区的现在时间
    }

    /**
     * 时区
     */
    @Test
    public void testZoneId() {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;//存放所有的时区
        String ctt = shortIds.get("CTT");//Asia/Shanghai ，代表着北京时间
        System.out.println(ctt);
    }
}
