package atguigu.io.otherIO;/**
 * @Author Curry
 * @Create 2020-11-17:54
 */

import java.io.Serializable;

/**
 *@Description todo
 *@ClassName Person
 *@Author admin
 *@Date 2020/11/22 17:54
 *@Version 1.0
 */
public class Person implements Serializable{
    public static final long serialVersionUID=423423523545L;
    private String name;
    private int age;

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
