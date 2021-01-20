package atguigu.TestThread;

/**
 * @Author Curry
 * @Create 2020-06-11:09
 */
public class MyThead extends Thread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "-->" + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "-->" + i);
                    }

                }
            }
        }.start();

        System.out.println("hello world");
    }
}
