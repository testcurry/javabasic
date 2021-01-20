package com.atguigu.stringTest;/**
 * @Author Curry
 * @Create 2020-11-22:23
 */

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Description todo
 * @ClassName StringTest1
 * @Author admin
 * @Date 2020/11/29 22:23
 * @Version 1.0
 */
public class StringTest1 {

    //String与byte[]之间的转换
    //编码：String-->bytes调用String的getBytes()方法
    //解码：byte[]-->String：调用String的构造器
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1="abc123中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集进行编码
        System.out.println(Arrays.toString(bytes));
        System.out.println("*************");
        byte[] gbks = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
        System.out.println("**************");
        String s = new String(bytes);
        System.out.println(s);
        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);

    }

    //String与char[]之间的转换
    @Test
    public void test2() {
        String str1 = "abc123";//题目：a21cb3
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str = new String(arr);
        System.out.println(str);
    }

    //String与基本数据类型和包装类之间的转换
    @Test
    public void test1() {
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);
        String s = String.valueOf(num);//"123"
        System.out.println(s.length());
        System.out.println(s);
        String str3 = num + "";//相当于new，在堆空间里
        System.out.println(str3);
        System.out.println(str1 == str3);
        //        System.out.println(str3.equals(str1));
    }
}
