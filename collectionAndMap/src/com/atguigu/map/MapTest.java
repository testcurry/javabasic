
package com.atguigu.map;
/**
 * @Author Curry
 * @Create 2020-11-3:32
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description todo
 * @ClassName MapTest
 * @Author admin
 * @Date 2020/11/26 3:32
 * @Version 1.0
 */

/*
* 一、Map的实现类的结构
*   1 Map：双列结构，存储key-value对的数据
*       1.1 HashMap作为Map的主要实现类，线程不安全，效率高；可以存储null的key和value
*           1.1.1 LinkedHashMap 保证在遍历map元素时，可以按照添加的顺序实现遍历
*           1.1.2 原因是在原有的HashMap底层结构上，添加了一对指针，指向了前一个和后一个元素
*           1.1.3 对于频繁的遍历操作，此类执行效率高于HashMap

*       1.2 TreeMap 保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序和定制排序
*           1.2.1 底层使用红黑树
*
*       1.3 HashTable 作为古老的实现类；线程安全 效率低
*           1.3.1 Properties 用来处理配置文件 key-和value都是String类型
*
*二、HashMap的底层：JDK7之前，数组+链表
*                   JDK1.8   数组+链表+红黑树

 三、Map结构的理解：
 1、Map中的key：无序的、不可重复的，使用Set存储所有的Key--->key所在的类要重写equals()和hashCode
 （以HashMap为例）
 2、map中的entry:无序的、不可重复的，使用Set存储所有的entry

 四、HashMap的底层实现原理？以jdk为例说明：
    4.1 HashMap map=new HashMap();底层创建了长度为16的一维数组Entry[] table
    4.2 可能执行了多次map map.put(key1,value1)
        4.2.1 首先，调用key1所在的类的hashCode()方法计算key1的哈希值，此哈希值经过某种算法计算以后，得到
    在Entry数组中的存放位置。
        4.2.2 情况一 如果此位置上的数据为空，此时的key-value添加成功
        4.2.1 情况二 如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在））
               ，比较key1，和已经存在的一个或多个数据的哈希值：
                如果key1的哈希值和已经存在的某个数据（key-value）的哈希值不相同，此时key1-value1添加成功
              情况三 ：如果key1的哈希值和已经存在的某个数据（key-value）的哈希值相同，则继续比较，调用
                       key1所在类的equals(key2)方法,比较：如果equals()返回false，此时key1-value1添加成功
                的equals()方法，比较：
               情况四：如果equals()返回true使用value1替换value2
        4.2.3 补充：关于情况2和情况三：此时key1-value1和原来的数据以链表的结构存储

    4.3 在不断的添加过程中，会涉及到扩容的问题，当超出临界值（且存放的位置为空时），扩容，默认的扩容方式
    ，扩容为原来的两倍，并将原有的数据复制过来

五、jdk8相对于jdk7在底层实现方面的不同
    1、new HashMap()底层没有创建一个长度为16的数组
    2、jdk8底层的数组是：Node[]，而非Entry[]
    3、首次调用put()方法时，底层创建了长度为16的数组
    4、jdk7底层的结构只有数组加链表，jdk8中底层结构：数组+链表+红黑树
        4.1 形成链表时，七上八下(jdk7新的元素指向旧的元素)jdk8旧的元素指向新的元素
        4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数大于8且当前数组的长度>64时，此时索引
        位置上的数据改成使用红黑树存储

    源码中一些名词的解释：
    DEFLAULT_INITIAL_CAPACITY:HashMap的默认容量16
    DEFAULT_LOAD_FACTORY:HashMap的默认加载因子0.75
    threshold:扩容的临界值，=容量*填充因子：16*0.75=12
    TREEIFY_THRESHOLD:Bucket中链表长度大于该默认值，转化为红黑树：8
    MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量64

 六、LinkedHashMap的底层实现原理(了解)：
  源码中：
  static class Entry<K,V>{
    Entry<K,V> before,after.//能够记录添加的元素的先后顺序
    Entry（int hash,K key,V value,Node<K,V> next）{
        super(hash,key,value,next);


    }
  }
 */


public class MapTest {

    //遍历map
    @Test
    public void test() {
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 456);
        map.put("CC", 789);
        //遍历所有的key集
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有得value
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println();
        //遍历所有得key-value
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        //方式二遍历所有的key-value
        System.out.println();
        Set set2 = map.keySet();
        Iterator iterator3 = set2.iterator();
        while (iterator3.hasNext()) {
            Object key = iterator3.next();
            System.out.println(key+"==="+map.get(key));
        }
    }


    @Test
    public void test4() {
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        System.out.println(map.get("AA"));
        boolean bb = map.containsKey("BB");
        System.out.println(bb);
        System.out.println(map.containsValue(56));
        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void test3() {
        HashMap map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 456);
        System.out.println(map);
        HashMap map1 = new HashMap();
        map1.put("CC", 1234);
        map1.put("DD", "test");
        map1.put("EE", "cytyh");
        map.putAll(map1);
        //删除
        Object value = map.remove("AA");
        System.out.println(value);
        map.clear();
        System.out.println(map.size());
        System.out.println(map);


    }

    @Test
    public void test2() {
        HashMap map = new HashMap();
        map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);
    }

    @Test
    public void test1() {
        HashMap map = new HashMap();
        map.put(null, 13);
        System.out.println(map);
        Hashtable map1 = new Hashtable();
//        map1.put(null, "tseret"); 不能添加null的key
    }


}
