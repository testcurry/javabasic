package atguigu.reflection;/**
 * @Author Curry
 * @Create 2020-11-23:40
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description todo
 * @ClassName ReflectionTest
 * @Author admin
 * @Date 2020/11/22 23:40
 * @Version 1.0
 */
public class ReflectionTest {
//反射之前对于person的操作
    @Test
    public void test() {
        Person person = new Person();
        person.setAge(18);
        String s = person.toString();
        System.out.println(s);
    }

    //使用反射对于person的操作
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz=Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Person person = (Person) cons.newInstance("test", 18);
        System.out.println(person.toString());
        //通过反射调用属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 22);
        System.out.println(person);
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

    }

    //获取class类的三种方式
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一调用运行类的属性
        Class clazz = Person.class;
        System.out.println(clazz);
        //方式二通过运行类的对象，调用getClass()
        Person p=new Person();
        Class clazz1 = p.getClass();
        System.out.println(clazz1);
        //方式三 调用Class的静态方法
        Class clazz2 = Class.forName("atguigu.reflection.Person");
        System.out.println(clazz2);

    }
}
