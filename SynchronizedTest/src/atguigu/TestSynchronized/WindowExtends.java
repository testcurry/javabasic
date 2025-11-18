package atguigu.TestSynchronized;

/**
 * @Author Curry
 * @Create 2020-06-23:07
 */
public class WindowExtends extends Thread {
    private static int ticket = 100;

    public static void main(String[] args) {
        WindowExtends w1=new WindowExtends();
        WindowExtends w2=new WindowExtends();
        w1.setName("线程一");
        w2.setName("线程二");
        w1.start();
        w2.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (WindowExtends.class) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
