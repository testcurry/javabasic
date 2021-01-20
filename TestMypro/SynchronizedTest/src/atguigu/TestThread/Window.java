package atguigu.TestThread;

/**
 * @Author Curry
 * @Create 2020-06-14:33
 */
public class Window implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Window w1=new Window();
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
