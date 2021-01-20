package atguigu.DateTest;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Curry
 * @Create 2020-07-0:42
 */
public class DetaApiTest {
    /*
    jdk1.8之前：
    1、simpleDateFormat日期时间类
    2、Calendar抽象类
    3、java.util.Date
    4、java.sql.Date
     */

    @Test
    public void testCalendar(){
        /*
        1、方式一：创建其子类java.util.GregorianCalendar的对象
        2、方式二：调用Calendar的静态方式返回Calender类的实例
         */

        //get
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        int i1 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(i1);
        System.out.println("*****************");
        //set
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        int i2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i2);
        //add
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        int i3 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i3);
        //getTime()
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime
        Date date1 = new Date();
        calendar.setTime(date1);
        int i4 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i4);

    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //方式一：使用simpleDateFormat无参的构造器
        //实例化
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        //格式化:日期-->到字符串
        String format = sdf.format(date);
        System.out.println(format);//20-7-22 下午8:25
        //格式化的逆过程 字符串-->日期
        String str = "20-7-22 下午8:25";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        System.out.println("------------------------------");
        //方式二  使用simpleDateFormat有参的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析
        Date date2 = sdf1.parse("2020-10-15 08:07:44");
        System.out.println(date2);

    }

    //练习：将"2020-09-08"转换为java.sql.Date
    @Test
    public void test4() throws ParseException {
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = sdf3.parse("2020-09-08");
        System.out.println(date3.getTime());
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
        System.out.println(date4);
    }
}
