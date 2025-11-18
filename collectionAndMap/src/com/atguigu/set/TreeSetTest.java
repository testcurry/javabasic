package com.atguigu.set;/**
 * @Author Curry
 * @Create 2020-11-1:56
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description todo
 * @ClassName TreeSetTest
 * @Author admin
 * @Date 2020/11/26 1:56
 * @Version 1.0
 */
public class TreeSetTest {
    @Test
    public void test() {
        //失败，不能添加不同类的对象
        TreeSet set = new TreeSet();
//        set.add(123);
//        set.add("test");
//        set.add(new User("Tom",30));
//        set.add(new User("Tom",30));
//        System.out.println(set);

        //举例1
//        set.add(123);
//        set.add(456);
//        set.add(789);
//        set.add(423);
//        System.out.println(set);

        //举例2 自然排序
        set.add(new User("Tom", 24));
        set.add(new User("Tom", 26));
        set.add(new User("Jack", 43));
        set.add(new User("Curry", 22));
        set.add(new User("Rose", 15));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int minusName = u1.getName().compareTo(u2.getName());
                    int minusAge = Integer.compare(u1.getAge(), u2.getAge());
                    if (minusName != 0) {
                        return -minusName;
                    } else {
                        return minusAge;
                    }
                } else {
                    throw new RuntimeException("类型不匹配！");
                }
            }
        });

        set.add(new User("Tom", 24));
        set.add(new User("Tom", 26));
        set.add(new User("Jack", 43));
        set.add(new User("Curry", 22));
        set.add(new User("Rose", 15));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


}
