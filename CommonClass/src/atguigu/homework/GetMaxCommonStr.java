package atguigu.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * .获取两个字符串中最大相同子串。
 * 比如： str1 = "abcwerthelloyuiodef“;str2 = "vhellobnmc"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 *
 * @Author Curry
 * @Create 2020-06-19:51
 */
public class GetMaxCommonStr {
    public static String getCommonStr(String str1, String str2) {
        if(str1!=null&&str2!=null){
            String mainStr = str1.length() >= str2.length() ? str1 : str2;
            String minStr = str1.length() < str2.length() ? str1 : str2;
            for (int i = 0; i < minStr.length(); i++) {
                for (int x = 0, y = minStr.length()-i; y <= minStr.length(); x++, y++) {
                    String substr = minStr.substring(x, y);
                    if (mainStr.contains(substr)) {
                        return substr;
                    }
                }
            }
        }
        return null;
    }

    public static String[] getMaxCommonStr(String str1,String str2){
        if (str1!=null&&str2!=null){
            StringBuffer sBuffer=new StringBuffer();
            String maxStr=(str1.length()>=str2.length())?str1:str2;
            String minStr=(str1.length()<str2.length())?str1:str2;
            int len=minStr.length();
            for (int i = 0; i < len; i++) {
                for (int x=0,y=len-i;y<=len;x++,y++){
                    String substring = minStr.substring(x, y);
                    if (maxStr.contains(substring)){
                        sBuffer.append(substring+",");
                    }
                }
                if (sBuffer.length()!=0){
                    break;
                }
            }
            System.out.println(sBuffer);
            String[] split=sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;

    }

    @Test
    public void test1() {
        String str1 = "abcwerthello123yuiodefhello456";
        String str2 = "cvhello123bnmhello456";
        String[] commonStr = getMaxCommonStr(str1, str2);
        System.out.println(Arrays.toString(commonStr));
    }
}
