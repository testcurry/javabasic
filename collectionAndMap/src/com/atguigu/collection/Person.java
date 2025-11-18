package com.atguigu.collection;/**
 * @Author Curry
 * @Create 2020-11-22:10
 */

/**
 *@Description todo
 *@ClassName Person
 *@Author admin
 *@Date 2020/11/24 22:10
 *@Version 1.0
 */
public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
//        System.out.println("equals()");//调用contains()和remove方法的时候都会调用equals方法
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
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