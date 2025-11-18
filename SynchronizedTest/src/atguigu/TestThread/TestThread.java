package atguigu.TestThread;

/**
 * @Author Curry
 * @Create 2020-06-12:03
 */
public class TestThread extends Thread {
    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(currentThread().getName() + "-->" + i);
            }
            if (i % 20 == 0) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                yield();
//                System.out.println(currentThread().getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        TestThread t1 = new TestThread("线程一");
        t1.start();
        currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            System.out.println(currentThread().getName()+":"+i);
            if (i%20==0){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());
    }
}
