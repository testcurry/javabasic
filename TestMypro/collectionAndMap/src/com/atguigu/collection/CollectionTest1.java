package atguigu.collection;/**
 * @Author Curry
 * @Create 2020-11-22:06
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description todo
 * @ClassName CollectionTest1
 * @Author admin
 * @Date 2020/11/24 22:06
 * @Version 1.0
 */
public class CollectionTest1 {

    //结论：向Collection接口的实现类的对象添加数据obj时，要求obj所在的类必须要重写equals()方法
    @Test
    public void test() {
        Collection list = new ArrayList();
        list.add(123);
        list.add(456);
        Person p = new Person("curry", 18);
        list.add(p);
        list.add(p);
        System.out.println(list);
        list.add(new Person("curry", 18));
        list.add(new Person("curry", 18));
        System.out.println(list);

        //contains(Object obj)方式的测试,在调用contains()方法时，会调用obj所在类的equals()方法
        boolean contains = list.contains(p);
        System.out.println(contains);
        System.out.println(list.contains(new Person("curry", 18)));
        System.out.println(list.contains(p));

        //containsAll(Collection coll)
        List list1 = Arrays.asList(123, 456);
        boolean b = list.containsAll(list1);
        System.out.println(b);
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("curry", 30));
        boolean remove = coll.remove(1234);
        System.out.println(remove);
        System.out.println(coll);
        Collection coll1 = Arrays.asList(123, 456);
        boolean b = coll.removeAll(coll1);
        System.out.println(coll);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("curry", 30));
        Collection coll1 = Arrays.asList(123, 456);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        Collection coll2 = Arrays.asList(123, 456, new Person("curry", 30));
        boolean equals = coll.equals(coll2);
        System.out.println(equals);

    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("curry", 30));

        System.out.println(coll.hashCode());
        //将集合转换为数组调用toArray()方法,将数组转换为集合调用Arrays工具类中的asList()方法
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

//        将数组转换为集合调用Arrays工具类中的asList()方法
        Collection coll1 = Arrays.asList(new String[]{"test", "234", "curry"});
        System.out.println(coll1.size());//3
        int[] arr1 = {12, 43, 343};
        Collection coll2=Arrays.asList(arr1);
        System.out.println(coll2.size());//1
        System.out.println(coll2);
        System.out.println(arr1);
        Collection coll3=Arrays.asList(new Integer[]{123,45,789});
        System.out.println(coll3.size());
    }

}
