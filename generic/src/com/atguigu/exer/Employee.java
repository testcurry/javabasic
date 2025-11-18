package com.atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-2:47
 */

/**
 * @Description todo
 * @ClassName Employee
 * @Author admin
 * @Date 2020/11/26 2:47
 * @Version 1.0
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private MyDate birth;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return birth != null ? birth.equals(employee.birth) : employee.birth == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
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

    public MyDate getBirth() {
        return birth;
    }

    public void setBirth(MyDate birth) {
        this.birth = birth;
    }

    public Employee(String name, int age, MyDate birth) {

        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public Employee() {

    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee) {
//            Employee e = (Employee) o;
//            int minusName = this.getName().compareTo(((Employee) o).getName());
//            int minusAge = this.getAge() - e.getAge();
//            int minusBirth = this.getBirth().compareTo(e.getBirth());
//
//            if (minusName != 0) {
//                return minusName;
//            }
//            if (minusAge != 0) {
//                return minusAge;
//            }
//            return minusBirth;
//        } else {
//            throw new RuntimeException("类型不匹配！");
//        }
//    }

    @Override
    public int compareTo(Employee o) {
        int minusName = this.getName().compareTo(o.getName());
        int minusAge = this.getAge() - o.getAge();
        int minusBirth = this.getBirth().compareTo(o.getBirth());

        if (minusName != 0) {
            return minusName;
        }
        if (minusAge != 0) {
            return minusAge;
        }
        return minusBirth;
    }
}
