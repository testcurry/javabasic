package com.atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-0:06
 */

import org.junit.Test;

/**
 * @Description todo
 * @ClassName StringDemo
 * @Author admin
 * @Date 2020/11/30 0:06
 * @Version 1.0
 */
public class StringDemo {

    @Test
    public void test() {
        String s1 = "test3456curry";
        String str = reverse2(s1, 2, 5);
        System.out.println(str);
    }

    //将一个字符串进行翻转，将字符串中指定位置进行翻转

    //方式一，转换为数组
    public String reverse(String str, int startIndex, int endIndex) {
        char[] arr = str.toCharArray();
        char temp;
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }

    //方式二
    public String reverse1(String str, int startIndex, int endIndex) {
        String firstStr = str.substring(0, startIndex);
        String threeStr = str.substring(endIndex + 1);
        for (int i = endIndex; i >= startIndex; i--) {
           firstStr += str.charAt(i);
        }
        return firstStr + threeStr;
    }

    //方式三 使用StringBuffer或者StringBuild替换String
    public String reverse2(String str, int startIndex, int endIndex) {
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex+1 ));

        return new String(builder);
    }

}