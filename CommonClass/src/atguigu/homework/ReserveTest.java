package atguigu.homework;

import org.junit.jupiter.api.Test;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反 转为”abfedcg”
 *
 * @Author Curry
 * @Create 2020-06-19:49
 */
public class ReserveTest {
    /*
    将一个字符串进行翻转，例如："abcdefg"反转为"abfedcg"
     */
    //方式一：将字符串转换为数组的思路
    public static String reserve(String str, int startIndex, int endIndex) {
        if (str != null) {
            char[] chars = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = chars[x];
                chars[x] = chars[y];
                chars[y] = temp;
            }
            return new String(chars);
        }
        return null;
    }

    //方式二:拼接的方式
    public static String reserve1(String str, int startIndex, int endIndex) {
        if (str != null) {
            String str1 = str.substring(0, startIndex);
            for (int i = endIndex; i >= startIndex; i--) {
                str1 += str.charAt(i);
            }
            str1 = str1 + str.substring(endIndex + 1);
            return str1;
        }
        return null;
    }

    //方式三：stringBuilder的方式，减少内存的使用，对方式二的优化
    public static String reserve2(String str, int startIndex, int endIndex) {
        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0, startIndex));
            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(endIndex+1));
            return builder.toString();
        }
        return null;


    }

    @Test
    public void test1() {
        String str1 = "abcdefg";
        String str2 = reserve2(str1, 2, 5);
        System.out.println(str2);
    }
}
