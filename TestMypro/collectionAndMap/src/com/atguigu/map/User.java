package com.atguigu.map;/**
 * @Author Curry
 * @Create 2020-11-1:43
 */

/**
 * @Description todo
 * @ClassName User
 * @Author admin
 * @Date 2020/11/26 1:43
 * @Version 1.0
 */
public class User implements Comparable {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
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

    public User(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public User() {

    }

    //姓名从大到小，年龄从小到大
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User u = (User) o;
            int compare = -this.name.compareTo(u.getName());
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.getAge(), u.getAge());
            }
        }else{

            throw new RuntimeException("类型不匹配！");
        }
    }
}
