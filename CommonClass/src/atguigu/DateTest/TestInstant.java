package atguigu.DateTest;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @Author Curry
 * @Create 2020-07-23:26
 */
public class TestInstant {
    @Test
    public void test1(){
        //获取本初子午线的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println("*********");
        //获取时间戳-->距离1970年0时0分0秒的毫秒数
        long epochSecond = instant.toEpochMilli();
        System.out.println(epochSecond);
        System.out.println("**************");
        //通过时间戳获取instant的实例
        Instant instant1=Instant.ofEpochMilli(1595432790779L);
        System.out.println(instant1);

    }
}
