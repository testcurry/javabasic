package atguigu.reflection;/**
 * @Author Curry
 * @Create 2020-11-23:41
 */

/**
 *@Description todo
 *@ClassName Person
 *@Author admin
 *@Date 2020/11/22 23:41
 *@Version 1.0
 */
public class Person {
    private String name;
    private int age;

    public void show(){
        System.out.println("你好我是一个中国人。。");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Person() {

    }
}
