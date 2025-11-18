package atguigu.homework;

import org.junit.jupiter.api.Test;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 *
 * @Author Curry
 * @Create 2020-06-19:50
 */
public class CountNumOfStr {
    public static int getNum(String str1, String str2) {
        String minStr = str1;
        String maxStr = str2;
        int index = 0;
        int count = 0;
        if (maxStr.length() > minStr.length()) {
            //方式一：
//            while ((index = maxStr.indexOf(minStr)) != -1) {
//                count++;
//                maxStr=maxStr.substring(index+minStr.length());
//            }
            //方式二
            while ((index = maxStr.indexOf(minStr, index)) != -1) {
                count++;
                index += minStr.length();
            }
            return count;
        } else {
            return 0;
        }
    }

    @Test
    public void test1() {
        String str1 = "ab";
        String str2 = "abkkcadkabkebfkabkskab";
        int num = getNum(str1, str2);
        System.out.println(num);
    }
}
