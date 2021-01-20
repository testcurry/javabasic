package com.atguigu.stringTest;/**
 * @Author Curry
 * @Create 2020-11-22:57
 */

import org.junit.Test;

/**
 * @Description todo
 * @ClassName StringBufferBuildTest
 * @Author admin
 * @Date 2020/11/29 22:57
 * @Version 1.0
 */
public class StringBufferBuildTest {
    //对比StringBuffer和StringBuild和String三者的效率
    //StringBuild>StringBuffer>String

    @Test
    public void test3() {
        long startTime=0L;
        long endTime=0L;
        String text="";
        StringBuffer buffer=new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime=System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("buffer执行的时间为："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("builder执行的时间为："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            text=text+i;
            
        }
        endTime=System.currentTimeMillis();
        System.out.println("String花费的时间为："+(endTime-startTime));
    }

    //测试StringBuffer中的常用方法
    @Test
    public void test2() {
        StringBuffer sb = new StringBuffer("abc");
        sb.append(1);
        sb.append('1');
        System.out.println(sb);
        sb.setCharAt(3, 't');
        System.out.println(sb);
        sb.delete(3, 8);
        System.out.println(sb);
        sb.replace(0, 4, "hello");
        System.out.println(sb);
        sb.insert(2, true);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String substring = sb.substring(2);
        String substring1 = sb.substring(1, 4);
        System.out.println(substring);
        System.out.println(substring1);
        System.out.println(sb.length());
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
        int index = sb.indexOf("oll");
        System.out.println(index);
    }

    /*
     * 比较String、StringBuffer和StringBuild三者的异同
     *
     *   1、String是不可变的字符序列，底层使用char[]存储
     *   2、StringBuffer是可变的字符序列，线程安全的，效率低，底层使用char[]存储
     *   3、StringBuild是可变的字符序列，底层使用char[]存储，线程不安全，效率高
     *
     *   源码分析：
     *   String str = new String();//char[] value=new char[0];
     *   String str1 = new String("abc");//char[] value=new char[]{'a','b','c'};
     *
     *   StringBuffer sb1=new StringBuffer();
     *   char[] value=new char[16];//地层创建了长度为16的数组
     *   System.out.println(sb1.length());
     *   sb1.append('a');//value[0]='a';
     *   sb1.append('b');//value[1]='b';
     *   StringBuffer sb2=new StringBuffer("abc");//char[] value=new char["abc".length+16];
     *
     *   问题一：
     *   System.out.println(sb2.length());//3,字符的个数，而不是底层数组的长度
     *   问题二：扩容问题：如果要添加的底层数组盛不下，那就需要扩容底层的数组。
     *   默认情况下，扩容为原来的两倍+2，同时将原有数组中的元素复制到新的数组中
     *
     *   指导意义：开发中，建议使用StringBuffer(int capacity)或StringBuild(int capacity)
     *
     *
     *
     *
     * */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }
}
