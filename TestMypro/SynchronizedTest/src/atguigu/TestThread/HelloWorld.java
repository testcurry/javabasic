package atguigu.TestThread;

/**
 * @Author Curry
 * @Create 2020-06-0:08
 */
public class HelloWorld extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
            
        }
    }

    public static void main(String[] args) {
        HelloWorld h1=new HelloWorld();

        HelloWorld h2=new HelloWorld();
        h1.setName("线程一");
        h1.start();
        h2.setName("线程二");
        h2.start();
        System.out.println("hello world");
    }

}
