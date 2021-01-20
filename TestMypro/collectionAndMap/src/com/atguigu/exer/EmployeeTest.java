package atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-3:07
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description todo
 * @ClassName EmployeeTest
 * @Author admin
 * @Date 2020/11/26 3:07
 * @Version 1.0
 */
public class EmployeeTest {

    //測試定制排序
    @Test
    public void test1() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    int minusName = e1.getName().compareTo(e2.getName());
                    int minusAge = Integer.compare(e1.getAge(), e2.getAge());
                    int minusBirth = e1.getBirth().compareTo(e2.getBirth());

                    if (minusName != 0) {

                        return minusName;
                    }
                    if (minusAge != 0) {
                        return minusAge;
                    }
                    return minusBirth;
                } else {
                    throw new RuntimeException("類型不匹配！");
                }
            }
        });

        Employee p1 = new Employee("liudehua", 45, new MyDate(1978, 5, 6));
        Employee p2 = new Employee("guofucheng", 56, new MyDate(1994, 6, 18));
        Employee p3 = new Employee("liudehua", 50, new MyDate(2000, 12, 12));
        Employee p4 = new Employee("zhangxueyou", 34, new MyDate(1965, 5, 6));
        Employee p5 = new Employee("liangchaowei", 18, new MyDate(2001, 5, 6));
        Employee p6 = new Employee("liudehua", 50, new MyDate(1973, 12, 12));
        Employee p7 = new Employee("liudehua", 50, new MyDate(1973, 10, 12));
        Employee p8 = new Employee("liudehua", 50, new MyDate(1973, 12, 11));

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);
        set.add(p8);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //測試自然排序
    @Test
    public void test() {
        TreeSet set = new TreeSet();

        Employee p1 = new Employee("liudehua", 45, new MyDate(1978, 5, 6));
        Employee p2 = new Employee("guofucheng", 56, new MyDate(1994, 6, 18));
        Employee p3 = new Employee("liudehua", 50, new MyDate(2000, 12, 12));
        Employee p4 = new Employee("zhangxueyou", 34, new MyDate(1965, 5, 6));
        Employee p5 = new Employee("liangchaowei", 18, new MyDate(2001, 5, 6));
        Employee p6 = new Employee("liudehua", 50, new MyDate(1973, 12, 12));
        Employee p7 = new Employee("liudehua", 50, new MyDate(1973, 10, 12));
        Employee p8 = new Employee("liudehua", 50, new MyDate(1973, 12, 11));

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);
        set.add(p8);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
