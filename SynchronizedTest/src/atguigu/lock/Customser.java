package atguigu.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。 有两个储户分别向同一个账户存3000元，每次存1000，存3次。
 * 每次存完打 印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 *
 * @Author Curry
 * @Create 2020-06-22:17
 */
class Account {
    private double balance;
    private ReentrantLock lock = new ReentrantLock();

    public void deposit(double amt) {
//        synchronized (lock) {
        if (amt > 0) {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                balance += amt;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
            }
        }
        try {
            }finally {
                lock.unlock();
            }

//        }
    }

}

public class Customser extends Thread {

    public static void main(String[] args) {
        Account acct = new Account();
        Customser cust1 = new Customser(acct);
        Customser cust2 = new Customser(acct);
        cust1.setName("线程一");
        cust2.setName("线程二");
        cust1.start();
        cust2.start();
    }

    private Account acct;

    public Customser(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        acct.deposit(1000);
    }
}
