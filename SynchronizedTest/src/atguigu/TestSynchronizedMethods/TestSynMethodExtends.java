package atguigu.TestSynchronizedMethods;

/**
 * @Author Curry
 * @Create 2020-06-23:20
 */
public class TestSynMethodExtends extends Thread {
    private static int ticket = 100;

    public static void main(String[] args) {
        TestSynMethodExtends w1 = new TestSynMethodExtends();
        TestSynMethodExtends w2 = new TestSynMethodExtends();
        w1.setName("线程一");
        w2.setName("线程二");
        w1.start();
        w2.start();
    }

    private static synchronized void sellTicket() throws InterruptedException {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
            sleep(100);
            ticket--;
        }
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
}
