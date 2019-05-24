package com.jcohy.study.java8.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.java8.time
 * Description  :
 */
public class TestLocalDateTime {

    //1. LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        System.out.println(ld2);

        LocalDateTime ldt3 = ld2.plusYears(20);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ld2.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    @Test
    public void test2(){
        Instant is = Instant.now();
    }
}
