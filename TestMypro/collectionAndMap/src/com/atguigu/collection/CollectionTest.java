package atguigu.collection;/**
 * @Author Curry
 * @Create 2020-11-0:30
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Description todo
 * @ClassName CollectionTest
 * @Author admin
 * @Date 2020/11/23 0:30
 * @Version 1.0
 */
public class CollectionTest {
    /*
     *一、集合框架的概述：
     *1、集合、数组都是对多个数据进行存储操作的结构，简称java容器
     *   说明：此时的存储都是内存层面的存储，不涉及到持久化的存储
     *
     * 2、数组在存储多个数据的时候的特点：
     *       2.1 一旦初始化长度就确定了
     *       2.2数组一旦定义好，其元素的类型也就确定了，我们只能存储指定类型的数据了
     *       2.3 数组存储多个数据的缺点
     *           2.3.1 数组中提供的方法非常有限，对于添加、删除、插入等操作，非常不便，同时效率不高
     *           2.3.2 获取数组中实际元素的个数的需求，数组中没有现成的属性和方法可以用
     *           2.3.3 数组存储数据的特点：有序、可重复 ，对于无序的、不可重复的的需求，不能满足
     *
     * 二、集合框架
     * 1、Collection接口：单列集合，用来存储一个一个的对象
     *          1.1 子接口 List 存储有序的、可重复的数据
     *               1.1.1 ArrayList 、LinkedList、Vector
     *           1.2 子接口 Set接口 存储无序的、不可重复的数据
     *                1.2.1 HashSet、LinkedHashSet、TreeSetTest
     *
     * 2、Map接口 双列集合，用来存储一对（key-value）键值对
     *      2.1 HashMap、LinkedHashMap、TreeMap、HashTable、Properties
     *
     *
     * */
    @Test
    public void testCollection() {
        Collection list = new ArrayList();
        list.add(123);
        list.add("tset");
        list.add(false);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        int size = list.size();
        System.out.println(size);
        list.clear();
        System.out.println(list.isEmpty());
        ArrayList list1 = new ArrayList();
        boolean b = list1.addAll(list);
    }

}
