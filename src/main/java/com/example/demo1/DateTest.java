package com.example.demo1;

import lombok.Data;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Data
public class DateTest {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = "2021-12-10 09:00";
        try {
            Date       parse      = dateFormat.parse(time);
            System.out.println(parse.toString());
            System.out.println(parse.getHours());
            System.out.println(parse.getMinutes());
            System.out.println(parse.getMonth());
            System.out.println(parse.getYear());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1() throws ParseException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        String time = "2021-12-10 09:00";
        time += ":00";
        Date       parse      = dateFormat.parse(time);
        System.out.println(dateFormat.format(parse));
    }

    @Test
    public  void test2(){
        String startTimeValue = "2021-12-23";
        String endTimeValue   = "2021-12-24";
        if (startTimeValue != null && endTimeValue != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date beginDate = dateFormat.parse(startTimeValue);
                Date endDate   = dateFormat.parse(endTimeValue);
                System.out.println(beginDate);
                System.out.println(endDate);
                System.out.println((endDate.getTime() - beginDate.getTime())/24/60/60/1000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
