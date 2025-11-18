package atguigu.DateTest;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author Curry
 * @Create 2020-07-22:36
 */
public class TestNewDate {
    /*
    localDate,localTime,localDateTime三个新的日期时间类1.8以后
    localDateTime相对用的比较多
     */

    @Test
    public void test1() {
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);
        System.out.println("***********************");
        //get
        LocalDateTime localDateTime = LocalDateTime.of(2020, 07, 22, 23, 32, 32);
        int dayOfMonth = localDateTime.getDayOfMonth();
        int value = localDateTime.getMonthValue();
        int dayOfYear = localDateTime.getDayOfYear();
        System.out.println(localDateTime);
        System.out.println(dayOfMonth);
        System.out.println(value);
        System.out.println(dayOfYear);
        System.out.println("***********************");
        //of-->相当于Calendar的set,但是localDateTime具有不可变性，Calendar不具有不可变性
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(2);
        System.out.println(localDateTime1);
        System.out.println(localDateTime);
        LocalDate localDate = LocalDate.of(2020, 7, 22);
        LocalDate localDate1 = localDate.withDayOfMonth(31);
        System.out.println(localDate1);
        System.out.println("************");
        //加减操作
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);
        LocalDateTime localDateTime3 = localDateTime.minusMonths(4);
        System.out.println(localDateTime3);
        System.out.println(localDateTime);


    }
}
