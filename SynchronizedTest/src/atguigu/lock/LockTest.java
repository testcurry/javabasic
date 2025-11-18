package atguigu.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Curry
 * @Create 2020-06-22:01
 */
public class LockTest extends Thread {
    public static void main(String[] args) {
        LockTest test1 = new LockTest();
        LockTest test2 = new LockTest();
        test1.setName("线程一");
        test2.setName("线程二");
        test1.start();
        test2.start();
    }

    private static int ticket = 100;
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
//            synchronized (lock) {
                try {
                    if (ticket > 0) {
                        System.out.println(getName() + "卖票，票号为-->" + ticket);
                        sleep(100);
                        ticket--;
                    } else {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
//            }
        }
    }
}
