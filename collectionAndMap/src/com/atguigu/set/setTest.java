package com.atguigu.set;/**
 * @Author Curry
 * @Create 2020-11-0:59
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @Description todo
 * @ClassName setTest
 * @Author admin
 * @Date 2020/11/25 0:59
 * @Version 1.0
 */
public class setTest {

    @Test
    public void test() {
        HashSet set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add("CC");
        set.add(new User("Tom", 30));
        set.add(new User("Tom", 30));
        set.add(129);
        System.out.println(set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        LinkedHashSet set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add("CC");
        set.add(new User("Tom", 30));
        set.add(new User("Tom", 30));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
