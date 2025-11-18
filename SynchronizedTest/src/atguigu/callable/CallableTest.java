package atguigu.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Curry
 * @Create 2020-06-1:10
 */
public class CallableTest implements Callable {
    public static void main(String[] args) {
        CallableTest c = new CallableTest();
        FutureTask f1 = new FutureTask(c);
        FutureTask f2 = new FutureTask(c);
        Thread t1 = new Thread(f1);
        t1.setName("线程一");
        Thread t2 = new Thread(f2);
        t2.setName("线程二");
        t1.start();
        t2.start();
        try {
//            System.out.println("总和为:-->" + f1.get());
//            System.out.println("总和为:-->" + f2.get());
            System.out.println("余票为:-->" + f2.get());
            System.out.println("余票为:-->" + f2.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private int ticket = 100;
    private static int sum = 0;

    public synchronized int getSum() {
        for (int i = 0; i <= 100; i++) {
            sum += i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
        return sum;
    }

    @Override
    public Object call() throws Exception {
        while (true) {
            if (ticket>0){
                sellTicket();
            }
             else {
                break;
            }

        }
        return ticket;
        /*for (int i = 0; i <= 100; i++) {
            sum += i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
        return getSum();*/
    }

    private synchronized void sellTicket() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
            ticket--;
        }
    }
}