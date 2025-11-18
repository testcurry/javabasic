package com.atguigu.genericTest;/**
 * @Author Curry
 * @Create 2020-12-23:57
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description todo
 * @ClassName GenericTest1
 * @Author admin
 * @Date 2020/12/1 23:57
 * @Version 1.0
 */
public class GenericTest1 {

    @Test

    public void test1() {
        Order order = new Order();
        order.setOrderT(124);
        order.setOrderT("test");

        Order<String> order1 = new Order<String>("orderAA", "1001", "order:AA");
        order1.setOrderT("AA:Hello");
        System.out.println(order1);
    }

    @Test
    public void test2() {
        SubOrder sub1 = new SubOrder();
        sub1.setOrderT(890);

        SubOrder1<String> sub = new SubOrder1<>();
        sub.setOrderT("test");
    }

    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();
        //泛型不同的引用不同相互赋值
        //list1=list2;

    }

    //测试泛型方法
    public void test4() {
        Order<String> order=new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);

    }

}
