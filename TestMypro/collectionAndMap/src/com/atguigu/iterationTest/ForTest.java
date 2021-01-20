package atguigu.iterationTest;/**
 * @Author Curry
 * @Create 2020-11-23:03
 */

import atguigu.collection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description todo
 * @ClassName ForTest
 * @Author admin
 * @Date 2020/11/24 23:03
 * @Version 1.0
 */
public class ForTest {

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new Person("curry", 22));
        //第一种方式遍历 推荐
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.toArray()[i]);
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testExer(){
        //增强for循环的一个练习
        ArrayList<Object> list = new ArrayList<>();
        list.add("MM");
        list.add("MM");

        for (Object obj:list){
            obj="GG";
        }

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
