package atguigu.TestStringMethods;

import org.junit.jupiter.api.Test;

/**
 * @Author Curry
 * @Create 2020-06-15:54
 */

public class TestMethods {

    /*
     String replace(char oldChar, char newChar)：返回一个新的字符串，它是 通过用 newChar 替换此字符串中出现的所有 oldChar
    得到的。
     String replace(CharSequence target, CharSequence replacement)：使 用指定的字面值替换序列替换此字符串所有匹配字面值
    目标序列的子字符串。
     String replaceAll(String regex, String replacement) ： 使用给 定 的 replacement 替换此字符串所有匹配给定的正则表达式
    的子字符串。
     String replaceFirst(String regex, String replacement) ： 使用给 定 的 replacement 替换此字符串匹配给定的正则表达式
    的第一个子字符串。boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此 字符串，最多不超过limit个，如果超过了，
      剩下的全部都放到最后一个元素中
     */

    @Test
    public void TestStringMethods() {
        String s1 = "上海吉贝克技术有限公司";
        String s2 = s1.replace('上', '下');
        System.out.println(s2);
        String s3 = s1.replace("上海", "下河");
        System.out.println(s3);
        System.out.println("*********************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成","
        String str1 = str.replaceAll("\\d+", ",");
        System.out.println(str1);
        //把字符串中的数字替换成",",如果结果中开头和结尾有","的话,就去掉
        String str2 = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(str2);
        String str3 = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str3.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-45342899";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
        System.out.println("*********************************");
        String str4 = "hello|world|java";
        String[] strs = str4.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str5 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }


    }

    /*
         boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
         boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
         boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的 子字符串是否以指定前缀开始
         boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列 时，返回 true
         int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
         int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出 现处的索引，从指定的索引开始
         int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
         int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后 一次出现处的索引，
        从指定的索引开始反向搜索 注：indexOf和lastIndexOf方法如果未找到都是返回-1

     */

    @Test
    public void testMethods3() {
        String s1 = "JavaEE";
        boolean s2 = s1.endsWith("EE");
        System.out.println(s2);
        boolean s3 = s1.startsWith("Java");
        System.out.println(s3);
        boolean b1 = s1.contains("ava");
        System.out.println(b1);
        String s4 = "helloworld";
        int s5 = s4.indexOf('o');
        System.out.println(s5);
        int s6 = s4.indexOf('o', 5);
        System.out.println(s6);
        int s7 = s4.lastIndexOf('o');
        System.out.println(s7);
        int s8 = s4.lastIndexOf('o', 5);
        System.out.println(s8);
        int s9 = s4.lastIndexOf('o', 9);
        System.out.println(s9);


    }

    /*
     * int length()：返回字符串的长度： return value.length
     *  char charAt(int index)： 返回某索引处的字符return value[index]
     *  boolean isEmpty()：判断是否是空字符串：return value.length == 0
     *  String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
     *  String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
     *  String trim()：返回字符串的副本，忽略前导空白和尾部空白
     *  boolean equals(Object obj)：比较字符串的内容是否相同
     *  boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大 小写
     *  String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
     *  int compareTo(String anotherString)：比较两个字符串的大小
     *  String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从 beginIndex开始截取到最后的一个子字符串。
     *  String substring(int beginIndex, int endIndex) ：返回一个新字符串，
     * 它是此字 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串
     */

    @Test
    public void testMethods2() {
        String s1 = "bbb";
        String s2 = "ada";
        //遍历字符串的所有字符的编码表对应的编号相减,如果第一个下标的字符相等则继续遍历，
        // 比较第二个字符，以此类推，直到对应位置下标的元素不相等，
        // 如果遍历完所有的元素都相等的话则返回0，表示两个字符串相等
        int s3 = s1.compareTo(s2);
        System.out.println(s3);
        String s4 = "javaee";
        String s5 = s4.substring(2);//2-数据最后一个下标位置的元素组成的字符串
        System.out.println(s5);
        String s6 = s4.substring(2, 5);//[2-5)的所有字符组成的字符串
        System.out.println(s6);
        CharSequence charSequence = s4.subSequence(2, 5);
        System.out.println(charSequence);
    }

    @Test
    public void testMethods() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        char s2 = s1.charAt(2);
        System.out.println(s2);
        boolean s3 = s1.isEmpty();
        System.out.println(s3);
        String s4 = "";
        boolean s5 = s4.isEmpty();
        System.out.println(s5);
        String s6 = s1.toLowerCase();
        System.out.println(s6);
        String s7 = s1.toUpperCase();
        System.out.println(s7);
        String s8 = "  he  llo world  ";
        String s9 = s8.trim();
        System.out.println("[" + s9 + "]");
        String s10 = new String("helloWorld");
        System.out.println(s1.equals(s10));
        System.out.println(s1.equalsIgnoreCase(s10));
        String s11 = s1.concat("love you");//等价于+的方式拼接
        System.out.println(s11);

    }
}
