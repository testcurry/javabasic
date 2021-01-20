package atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-2:24
 */

import atguigu.collection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *@Description todo
 *@ClassName CollectionTest
 *@Author admin
 *@Date 2020/11/26 2:24
 *@Version 1.0
 */
public class CollectionTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(new Person("Tom",30));
        list.add(new Person("Tom",30));
        list.add(new Person("Tom",30));
        list.add(new Person("Tom",30));
        list.add(new Person("Tom",30));
        list.add(123 );
        list.add(123 );
        list.add(456 );
        List list1 = duplicateList(list);
        list1.forEach(System.out::println);
    }

    //练习 在list内去除重复的数字，要求尽量的简单
    public static List duplicateList(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(new Integer(12));
        list.add(new Integer(12));
        list.add(new Integer(34));
        list.add(new Integer(56));
        list.add(new Integer(56));
        list.add(new Integer(56));

        List list1 = duplicateList(list);
        for (Object obj:list1){
            System.out.println(obj);
        }

    }

    //经典的面试题，一题测试你对set底层的理解是否到位

    @Test
    public void test2(){
        HashSet<Object> set = new HashSet<>();

        Person p1 = new Person("AA", 30);
        Person p2 = new Person("BB", 22);
        set.add(p1);
        set.add(p2);
        System.out.println(set);//两个数据，就是p1和p2
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);//两个数据，AA数据被修改为CC，单hashCode()值还是AA的，
        // 所以remove的时候通过P1也就是CC计算的hashCode的位置没有数据，删除失败

        set.add(new Person("CC",30));
        System.out.println(set);//三个数据，CC计算的hashCode的位置没有数据，直接添加成功

        set.add(new Person("AA", 22));
        System.out.println(set);//四个数据，AA计算的hashCode的位置有数据，所以进行equals比较
        //比较出来值不相等，因为之前的AA已经被改为CC了，所以以链表的结构添加成功
    }
}
