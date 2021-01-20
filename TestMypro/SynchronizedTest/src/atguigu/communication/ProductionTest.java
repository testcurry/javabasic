package atguigu.communication;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处 取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图 生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通 知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如 果店中有产品了再通知消费者来取走产品
 *
 * @Author Curry
 * @Create 2020-06-23:53
 */

class Clerk {
    private int production;

    public synchronized void addProductor() {
        if (production < 20) {
            notify();
            production++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + production + "个产品");
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void getProductor() {
        if (production > 0) {
            notify();
            System.out.println(Thread.currentThread().getName() + "消费了第" + production + "个" + "产品");
            production--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("生产者开始生产。。。");
            clerk.addProductor();

        }
    }
}

class Customser extends Thread {

    private Clerk clerk;

    public Customser(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("消费者开始消费。。。");
            clerk.getProductor();

        }
    }
}

public class ProductionTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor p = new Productor(clerk);
        Customser c1= new Customser(clerk);
        Customser c2 = new Customser(clerk);
        p.setName("生产者");
        c1.setName("消费者1");
        c2.setName("消费者2");
        p.start();
        c1.start();
        c2.start();
    }
}
