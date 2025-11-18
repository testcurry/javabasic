package atguigu.communication;

/**
 * @Author Curry
 * @Create 2020-06-23:26
 */
public class TestCommunication implements Runnable {
    public static void main(String[] args) {
        TestCommunication test = new TestCommunication();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }

    private int num;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                obj.notify();
                if (num < 100) {
                    num++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-->" + num);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
