package atguigu.StringTest;

import org.junit.jupiter.api.Test;

/**
 * @Author Curry
 * @Create 2020-06-16:15
 */
public class TestString {
    @Test
    public void testPerson() {
        Person p1 = new Person("tom", 18);
        Person p2 = new Person("tom", 18);
        //基本数据类型==比较的就是数值本身，所以很明显就是true
        System.out.println(p1.age == p2.age);
        //引用数据类型比较的是地址值，此时比较的是两个对象的String类型的name属性对应的地址值是否相等
        //new了两个对象，name属性对应的值指向的地址是方法区的字符串“tom"的地址，方法区的字符串只能有一个
        // ，不能有重复的，所以是相同的
        System.out.println(p1.name == p2.name);
        p1.name = "jerry";
        System.out.println(p2.name);

    }

    //String代表不可变的字符序列，简称不可变性
    @Test
    public void testString3() {
        String s1 = "abc";//字面量，声明的s1在栈，"abc"在方法区，方法区的数据不会重复，只会保存一份
        String s2 = "abc";//所以当声明s2也是“abc"的时候，常量区已经存在abc数据，就直接将地址值赋给了s2
        System.out.println(s1 == s2);//内存中指向同一个地址，所以结果是true
        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("***************");
        String s3 = "abc";
        s3 += "def";//此时拼接之后的字符串是在方法区新造的，不是在原来的基础上拼接的
        System.out.println(s2);//"abc"，因为s2和s3在拼接之前都是指向方法区的"abc"，指向是同一个字符串。拼接后s2没变
        System.out.println(s3);//"abcdef"//但是s3变成abcdef，说明abcdef是新造的，而不是在原来的基础上拼接的，此处还是体现
        // 了字符串的不可变性

        System.out.println("****************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//"abc"
        System.out.println(s5);//"mbc"
    }


    @Test
    public void TestString2() {
        /**
         * 结论：
         * 1、常量和常量的拼接结果在常量池，
         * （此时的常量包括final修饰的变量，因为final修饰的变量也是常量）
         * 且常量池中不会存在相同内容的常量
         * 2、只要有一个是变量，结果就在堆中（此时的变量相当于new了一个String）
         * 3、如果拼接的结果调用了intern()方法，返回值就在常量池中
         */
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        String s8=s5.intern();//intern()方法返回的值s8使用的是常量池中已经存在的"hello world"的地址
        System.out.println(s8 == s3);
    }

    @Test
    public void TestString() {
        String s1 = new String("test");
        String s2 = s1.toUpperCase();
        String s3 = "HELLO WORLD";
        String S4 = s3.toLowerCase();
        System.out.println(S4);
        System.out.println(s2);
        System.out.println(s1);
    }
}
