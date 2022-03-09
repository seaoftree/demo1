package com.example.demo1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author a58
 */
public class TestDate {
    public static void main(String[] args) throws InterruptedException, ParseException {
//        Date beginDate = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(beginDate);
//        c.add(Calendar.DATE, Integer.parseInt("2"));
//        System.out.println(c.get(Calendar.MONTH));
//        System.out.println(c.get(Calendar.DATE));
//        System.out.println(c.get(Calendar.HOUR_OF_DAY));
//        System.out.println(c.get(Calendar.MINUTE));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2022-10-12 12:12:12");
        System.out.println(date);
        Thread.sleep(1000);
        Date date1 = simpleDateFormat.parse("2022-10-12 12:12:13");
        System.out.println(date1);
        System.out.println(date1.after(date));

    }
    @Test
    public void test() throws InterruptedException {
//        Map<String,String> map = new HashMap<>();
//
//        map.put("sea","23");
//        map.forEach((key,value) -> {
//            System.out.println(key + " " + value);
//        });
        Date beginDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(beginDate);
        c.add(Calendar.DATE, Integer.parseInt("2"));
        Date endDate = c.getTime();
        System.out.println(beginDate.toLocaleString());
        System.out.println(endDate.toLocaleString());
//        Thread.sleep(1000);
        System.out.println(beginDate.getTime());
        long time = new Date().getTime();
        System.out.println(time);
        System.out.println(beginDate.before(new Date()));
    }

    @Test
    public void test2(){
        Date     beginDate = new Date();
        Calendar c         = Calendar.getInstance();
        c.setTime(beginDate);
        c.add(Calendar.DATE, Integer.parseInt("365"));
        Date endDate = c.getTime();
        System.out.println(beginDate);
        System.out.println(endDate);
    }
}
