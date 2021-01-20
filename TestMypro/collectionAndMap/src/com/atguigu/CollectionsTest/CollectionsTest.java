package com.atguigu.CollectionsTest;/**
 * @Author Curry
 * @Create 2020-11-3:55
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description todo
 * @ClassName CollectionsTest
 * @Author admin
 * @Date 2020/11/29 3:55
 * @Version 1.0
 */
public class CollectionsTest {

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(123564);
        list.add(16753);
        list.add(78);
        list.add(456);

//        ArrayList<Object> list1 = new ArrayList<>();
//        Collections.copy(list1,list);//java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        ArrayList list1 = new ArrayList(list.size());
//        Collections.copy(list1, list);
        //正确的
        ArrayList list1 = new ArrayList(Arrays.asList(new Object[list.size()]));
        Collections.copy(list1, list);
        System.out.println(list1);
        List list2 = Collections.synchronizedList(list);
        System.out.println(list2);
    }

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(123564);
        list.add(16753);
        list.add(78);
        list.add(456);
//        Collections.sort(list);
//        Collections.shuffle(list);
//        Collections.reverse(list);
        System.out.println(list);
        Collections.swap(list, 2, 4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        int count = Collections.frequency(list, 123);
        System.out.println(count);
    }
}
