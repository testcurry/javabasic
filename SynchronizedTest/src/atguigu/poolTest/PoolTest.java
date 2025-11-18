package atguigu.poolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Curry
 * @Create 2020-06-2:20
 */

class PThead1 implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }

        }
    }
}

class PThead2 implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }

        }
    }
}

public class PoolTest {
    public static void main(String[] args) {
        PThead1 p1 = new PThead1();
        PThead2 p2 = new PThead2();
        ExecutorService service = Executors.newFixedThreadPool(10);
//        Future<?> call = service.submit(new FutureTask(new CallableTest()));
        service.execute(p1);
        service.execute(p2);
        service.shutdown();
    }
}
