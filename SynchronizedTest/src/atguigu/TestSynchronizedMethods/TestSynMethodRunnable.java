package atguigu.TestSynchronizedMethods;

/**
 * @Author Curry
 * @Create 2020-06-23:27
 */
public class TestSynMethodRunnable implements Runnable {
    private  int ticket = 100;

    public static void main(String[] args) {
        TestSynMethodRunnable tsyn = new TestSynMethodRunnable();
        Thread t1 = new Thread(tsyn);
        Thread t2 = new Thread(tsyn);
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        while (true) {
            try {
                sellTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void sellTicket() throws InterruptedException {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "-->" + ticket);
            Thread.sleep(10);
            ticket--;
        }
    }
}
