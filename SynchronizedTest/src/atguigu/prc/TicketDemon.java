package atguigu.prc;

/**
 * @Author Curry
 * @Create 2020-06-14:14
 */
public class TicketDemon extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        TicketDemon w1=new TicketDemon();
        TicketDemon w2=new TicketDemon();
        TicketDemon w3=new TicketDemon();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
