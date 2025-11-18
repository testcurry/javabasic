package com.atguigu.stringTest;/**
 * @Author Curry
 * @Create 2020-11-4:51
 */

import org.junit.Test;

/**
 * @Description todo
 * @ClassName StringMethodsTest
 * @Author admin
 * @Date 2020/11/29 4:51
 * @Version 1.0
 */
public class StringMethodsTest {

    @Test
    public void test4() {
        String str1="北京尚硅谷北京";
        String str2 = str1.replace("北京", "东京");
        System.out.println(str2);
        System.out.println("****************");
        String str="12hello34world5java789mysql456";
        String str3 = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(str3);
        System.out.println("**************");
        str="123456";
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel="0571-4534289";
        boolean matches1 = tel.matches("0571-\\d{7,8}");
        System.out.println(matches1);
        System.out.println("*********");
        str1="hello|world|java";
        String[] strs = str1.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        //        System.out.println(Arrays.toString(strs));
        System.out.println();
        str2="hello.world.java";
        String[] strs1 = str2.split("\\.");
        for (int i = 0; i < strs1.length; i++) {
            System.out.println(strs1[i]);

        }
    }

    @Test
    public void test3() {
        String str1 = "HellorWworld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);
        boolean b2 = str1.startsWith("He");
        System.out.println(b2);
        String str2 = "wor";
        boolean contains = str1.contains(str2);
        System.out.println(contains);
        int index = str1.indexOf("llo");//返回指定字符串在此字符串第一次出现的索引
        System.out.println(index);
        int index1 = str1.indexOf("o", 5);//从指定的索引开始，返回指定的字符串在此字符串中第一次出现的位置
        System.out.println(index1);
        System.out.println(str1.lastIndexOf("or"));//返回指定的字符串在此字符串最右边出现处的索引（倒着找）
        System.out.println(str1.lastIndexOf("or", 7));//返回指定字符串在此字符串中最后一次出现的索引，
        // 从指定的索引开始反向搜索

        //问题：什么情况下，indexOf(str)和lastIndexOf(str)返回的值相同？
        //存在唯一的str，或者不存在str 返回-1

    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);
        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//涉及到字符串的排序

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);
        String s9 = s7.substring(2, 5);
        System.out.println(s9);

    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));
//        s1="";
//        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        String s3 = "  hell  o  world";
        String s4 = s3.trim();
        System.out.println("-------" + s3 + "-------------");
        System.out.println("-------" + s4 + "-------------");


    }
}
