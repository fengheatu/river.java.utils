package com.river.utils.java8;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author he.feng
 * @2018/6/20
 * @desc
 */
public class DateTest {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date convert(String dateStr) throws ParseException {
        return df.get().parse(dateStr);
    }


    /**
     * localDate  localTime localDateTime
     */
    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2015,11,11,11,11,11,11);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.plusYears(2);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.minusYears(2);
        System.out.println(localDateTime3);

        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
    }

    /**
     * Instant 时间戳
     */
    @Test
    public void test2() {

        //默认获取utc时区时间
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(now.toEpochMilli());
    }

    /**
     * Duration 计算两个时间的间隔
     *
     * Period 计算两个日期之间的间隔
     */
    @Test
    public void test() throws InterruptedException {
        Instant ins1 = Instant.now();
        Thread.sleep(1000);
        Instant ins2 = Instant.now();
        Duration between = Duration.between(ins1, ins2);
        System.out.println(between);
        System.out.println(between.toMillis());
        System.out.println(between.getSeconds());

        System.out.println("--------------------------");

        LocalTime localTime = LocalTime.now();
        Thread.sleep(1000);
        LocalTime localTime1 = LocalTime.now();
        Duration between1= Duration.between(localTime, localTime1);
        System.out.println(between1);
        System.out.println(between1.getSeconds());
    }

    @Test
    public void test3() {
        LocalDate localDate = LocalDate.of(2015,1,1);
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate1);
        Period between = Period.between(localDate, localDate1);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }


    /**
     * 时间矫正器
     * TemporalAdjuster
     */
    @Test
    public void test4() {
        LocalDateTime ld = LocalDateTime.now();
        LocalDateTime with = ld.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);

    }


    /**
     * DateTimeFormatter :时间格式化
     */
    @Test
    public void test5() {
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldf = LocalDateTime.now();
        String format = df.format(ldf);
        System.out.println(format);

        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = df2.format(ldf);
        System.out.println(format1);
    }


    @Test
    public void test6() {
        Date date = new Date();
        System.out.println(date.getTime() / (1000 * 60));
    }
}
