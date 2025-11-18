package com.atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-4:39
 */

import org.junit.Test;

/**
 * @Description todo
 * @ClassName StringTest
 * @Author admin
 * @Date 2020/11/29 4:39
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void test() {
        String str = new String("good");
        char[] ch={'t','e','s','t'};

        change(str, ch);
        System.out.println(str);//good
        System.out.println(ch);//best
    }

    public void change(String str,char[] ch){
        str="test ok";
        ch[0]='b';
    }
}
