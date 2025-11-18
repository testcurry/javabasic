package com.atguigu.map;/**
 * @Author Curry
 * @Create 2020-11-3:31
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description todo
 * @ClassName TreeMapTest
 * @Author admin
 * @Date 2020/11/29 3:31
 * @Version 1.0
 */
public class TreeMapTest {

    //定制排序
    @Test
    public void test1() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int minusName = u1.getName().compareTo(u2.getName());
                    int minusAge = Integer.compare(u1.getAge(), u2.getAge());
                    if (minusName != 0) {
                        return -minusName;
                    }
                    return minusAge;
                }
                return 0;
            }
        });

        User u1 = new User("Tom", 22);
        User u2 = new User("Jack", 39);
        User u3 = new User("Lily", 34);
        User u4 = new User("Rose", 26);
        User u5 = new User("Rose", 30);
        map.put(u1, 100);
        map.put(u2, 100);
        map.put(u3, 100);
        map.put(u4, 100);
        map.put(u5, 100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())

        {
            System.out.println(iterator.next());
        }
    }

    //自然排序
    @Test
    public void test() {
        TreeMap<Object, Object> map = new TreeMap<>();
        User u1 = new User("Tom", 22);
        User u2 = new User("Jack", 39);
        User u3 = new User("Lily", 34);
        User u4 = new User("Rose", 26);
        User u5 = new User("Rose", 30);
        map.put(u1, 100);
        map.put(u2, 100);
        map.put(u3, 100);
        map.put(u4, 100);
        map.put(u5, 100);
//        map.put("test", 123); key必须是同一个类的对象
        Set<Map.Entry<Object, Object>> set = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
