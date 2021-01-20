package com.atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-0:49
 */

import org.junit.Test;

/**
 * @Description todo
 * @ClassName StringDemo1
 * @Author admin
 * @Date 2020/11/30 0:49
 * @Version 1.0
 */
public class StringDemo1 {
    //获取一个字符串在另一个字符串中出现的次数

    @Test
    public void test() {
        String mainstr = "adfasdfsdfdsfdf234sdfsdf";
        String subStr = "sd";
        int count = getCount1(mainstr, subStr);
        System.out.println(count);
    }

    //方式一
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subLength);
            }
        }
        return count;
    }

    //方式二
    public int getCount1(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
        }
        return count;
    }
}
