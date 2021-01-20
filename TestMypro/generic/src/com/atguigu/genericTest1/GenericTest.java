package com.atguigu.genericTest1;/**
 * @Author Curry
 * @Create 2020-12-1:07
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Description todo
 * @ClassName GenericTest
 * @Author admin
 * @Date 2020/12/2 1:07
 * @Version 1.0
 */
public class GenericTest {

    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        //编译不通过
        Date date = new Date();
//        str=date;

        //此时list1和list2不具备子父类关系，可以理解为是两个并行的类
        List<Object> list1 = null;
        List<String> list2 = null;
//        list1=list2;

        show(list1);
        show1(list2);

        List<?> list = null;

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("Tom");
        list3.add("Curry");
        list3.add("Jerry");
        list = list3;
//        通配符的泛型不能添加数据，因为不知道你要添加什么类型的数据
        //        list.add("test");
//        但是可以读取数据
        Object o = list.get(0);
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {

            Object next = iterator.next();
            System.out.println(next);
        }

    }

    public void show1(List<String> list) {

    }

    public void show(List<Object> list) {

    }

    /*
        有限制条件的通配符的使用：
            ? extends A （可以理解为小于等于A）
            G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

            ？ super A  （可以理解为大于等于A）
            G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类



    */

    @Test
    public void test4() {
        List<? extends Person> list1=null;
        List<? super Person> list2=null;
        ArrayList<Student> list3 = new ArrayList<>();
        ArrayList<Person> list4 = new ArrayList<>();
        ArrayList<Object> list5 = new ArrayList<>();

        list1=list3;
        list1=list4;
//        list1=list5;
//        list2=list3;
        list2=list4;
        list2=list5;
        //读取数据
        list1=list3;
        Person person = list1.get(0);
        //编译报错
        //        Student p = list1.get(0);

        list2=list4;
        Object object = list2.get(0);
        //编译不通过
//        Student stu = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Student());
        //编译通过
        list2.add(new Person());
        list2.add(new Student());
    }

}
