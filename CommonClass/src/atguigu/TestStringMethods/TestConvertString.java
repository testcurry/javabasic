package atguigu.TestStringMethods;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Author Curry
 * @Create 2020-06-18:53
 */
public class TestConvertString {
    //字符串和byte数组之间的转换
    @Test
    public void testConvertByte() {
        String s1 = "abc中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集进行编码
        System.out.println(Arrays.toString(bytes));//中文在utf8字符集中一个汉字占3个字节
        String s2=new String(bytes);
        System.out.println(s2);
        try {
            byte[] byte1 = s1.getBytes("gbk");//使用指定字符集为gbk进行编码，中文在gbk字符集中一个中文占两个字节
            System.out.println(Arrays.toString(byte1));
            //解码时要和编码时的字符集一致，否则会乱码
            String s3 = new String(byte1,"gbk");
            System.out.println(s3);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //字符串和char数组之间的转换
    @Test
    public void testConvertArry() {
        String s1 = "helloworld";
        char[] ch = s1.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
        char[] ch2 = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s2 = new String(ch2);
        System.out.println(s2);
    }


    //字符串和包装类之间的转换
    @Test
    public void testConvertString() {
        String s1 = "123";
        int i = Integer.parseInt(s1);
        System.out.println(i);
        String s2 = String.valueOf(1354.0);
        System.out.println(s2);
        boolean b1 = false;
        String s3 = String.valueOf(b1);
        System.out.println(s3);
        Double d = new Double(1314.5);
        String s4 = String.valueOf(d);
        System.out.println(s4);
    }


}
