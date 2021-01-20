package com.atguigu.genericTest;/**
 * @Author Curry
 * @Create 2020-12-23:39
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description todo
 * @ClassName GenericTest
 * @Author admin
 * @Date 2020/12/1 23:39
 * @Version 1.0
 */
public class GenericTest {

    //在集合中使用泛型的情况
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1234);
        list.add(456);
        list.add(54);
        list.add(89);
        //编译时就会进行类型检查，保证数据的安全
//        list.add("tom");
        //方式一遍历
        for (Integer i : list) {
            int score = i;
            System.out.println(score);
        }
        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer score = iterator.next();
            System.out.println(score);
        }
    }

    //map中使用泛型的情况
    @Test
    public void test2() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom", 89);
        map.put("Curry", 100);
        map.put("Jerry", 99);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"==="+value);
        }


    }
}
