package atguigu.TestSynchronized;

/**
 * @Author Curry
 * @Create 2020-06-22:30
 */
public class Windows implements Runnable {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        t1.start();
        t2.start();
    }

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + ticket);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
