package com.atguigu.List;/**
 * @Author Curry
 * @Create 2020-11-23:50
 */

import com.atguigu.collection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description todo
 * @ClassName ListTest
 * @Author admin
 * @Date 2020/11/24 23:50
 * @Version 1.0
 */
/*
* ArrayList的源码分析
*
*
*
* */

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
 *          1.1 子接口 List 存储有序的、可重复的数据,动态数组，替换原有的数组
 *               1.1.1 ArrayList 作为List接口的主要实现类，线程不安全，效率高，底层使用Object[] elementData数组存储
  *               1.1.2 LinkedList 对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
  *               1.1.3 Vector 作为List接口的古老实现类；线程安全，效率低；底层使用Object[]elementData存储
 *           1.2 子接口 Set接口 存储无序的、不可重复的数据
 *                1.2.1 HashSet、LinkedHashSet、TreeSetTest
 *
 * 2、ArrayList源码分析：
 *      2.1：JDK7情况下：
 *          2.1.1   ArrayList list =new ArrayList();底层创建了长度为10的Object[]数组elementData
 *          2.1.2        如果一直添加数据，导致底层elementData数组容量不够，则扩容
 *          2.1.3            默认情况下，扩容为原来的1.5倍，同时需要将原有数组中的数据复制到新数组中
 *          2.1.4       结论:建议开发中使用带参数的构造器：ArrayList list=new ArrayList(int capacity);

 *      2.2 JDK1.8中的变化：
 *          2.2.1 ArrayList list =new ArrayList();底层Object[] elementData初始化为{}，并没有创建类长度为10的数组
 *          2.2.2 当第一次调add()方法的时候，底层才创建长度为10的数组，并将第一个数据添加到Object[0]的位置
 *          2.2.3 后续添加和扩容的方式与JDK1.7无异
 *
 *      2.3小结:
 *          JDK1.7的ArrayList的对象的创建类似于单例的饿汉式，而JDK8的ArrayList的对象的创建类似于单例的懒汉式，
 *          延迟了对象的创建，节省了内存
 *
 *3、LinkedList的源码分析：
 *      3.1 LinkedList list=new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 *      3.2 当list.add(123)时，将123封装到Node中，创建Node对象
 *      3.3 其中，Node定义为：体现了LinkedList的双向链表的说法
 *          private static class Node<E>{
 *              E item;
 *              Node<E> next;
 *              Node<E> prev;
 *              Node(Node<E> prev,E element,Node<E> next){
 *                  this.item =element;
 *                  this.next=next;
 *                  this.prev=prev;
 *              }
 *          }
 *
 *
 *
 * */

public class ListTest {

    @Test
    public void test1() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(456);
        list.add(new Person("curry",18));
        list.add(new Person("curry",18));
        list.add(new Person("curry",18));
        list.add(new Person("curry",18));

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        int index = list.indexOf(456);
        System.out.println(index);
        System.out.println(list.lastIndexOf(456));
        list.remove(1);
        System.out.println(list);
        Object remove = list.remove(new Integer(456));
        System.out.println(remove);
        Object set = list.set(0, 789);
        System.out.println(set);
        System.out.println(list);
        List<Object> subList = list.subList(1, 3);
        System.out.println(subList);
    }

    @Test
    public void test2(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(456);
        list.add(new Person("curry",18));
        list.add(new Person("curry",18));
        list.add(2, 000);
        System.out.println(list);
        List<Integer> list1 = Arrays.asList(321, 654, 987);
        list.addAll(list1);
        System.out.println(list);
        Object o = list.get(2);
        System.out.println(o);
    }
}
