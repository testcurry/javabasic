package com.atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-0:49
 */

import org.junit.Test;

/**
 * @Description todo
 * @ClassName StringDemo2
 * @Author admin
 * @Date 2020/11/30 0:49
 * @Version 1.0
 */
public class StringDemo2 {

    //获取两个字符串中最大的相同子串

    @Test
    public void test() {
        String str1 = "abcwertyhellooiooudhfsdhtestcy";
        String str2 = "cvbnmthellootestcy";
        String maxCommonString = getMaxCommonString(str1, str2);
        System.out.println(maxCommonString);
//        String[] maxCommonString = getMaxCommonString1(str1, str2);
//        System.out.println(Arrays.toString(maxCommonString));

    }

    //先降低难度，假设两个字符串中只有一个最大相同子串
    public String getMaxCommonString(String str1, String str2) {
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++, y++) {
                String substring = minStr.substring(x, y);
                if (maxStr.contains(substring)) {
                    return substring;
                }
            }
        }
        return null;
    }

    //包含多个相同子串
    public String[] getMaxCommonString1(String str1, String str2) {
        StringBuffer buffer = new StringBuffer();
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++, y++) {
                String substring = minStr.substring(x, y);
                if (maxStr.contains(substring)) {
                    buffer.append(substring + ",");
                }
            }
            if (buffer.length() != 0) {
                break;
            }
        }
        String s = new String(buffer);
        String[] arr = s.replaceAll(",$", "").split("\\,");
        return arr;
    }
}
