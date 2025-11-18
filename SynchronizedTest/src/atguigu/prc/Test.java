package atguigu.prc;

/**
 * @Author Curry
 * @Create 2020-06-21:39
 */
public class Test {
    public static void main(String[] args) {
        String s0=new String("sdfs");
        String s1="abc";
        String s2 = s1.replace("abc", "test");
//        String s2 = s1.replace("abc","test");
        System.out.println(s2);
//        String s3 = s1.replace("def","test");
//        System.out.println(s1);
//        System.out.println(s3);
        Test test =new Test();
        Student[] stu=new Student[10];
        for (int i = 0; i < 10; i++) {
            stu[i]=test.new Student();
            stu[i].i=i+1;
            stu[i].state=i*2;
//            System.out.println(stu[i].state);
        }
    }

    class Student{
        int i;
        int state;
    }
}
