package atguigu.TestBank;

/**
 * @Author Curry
 * @Create 2020-06-0:21
 */
public class SingleTon {
    public static void main(String[] args) {
        SingleTon.getInstance().print();
    }
    private SingleTon() {

    }

    private static SingleTon singleTon = null;

    //方式一：同步方法
    public synchronized static SingleTon getInstance() {
        if (singleTon == null) {
             singleTon = new SingleTon();
        }
        return singleTon;
    }

//    方式二：同步代码块
 /*   public static SingleTon getInstance(){
        synchronized(SingleTon.class){
            if (singleTon == null) {
                 singleTon = new SingleTon();
            }
            return singleTon;
        }
    }*/

//    方式三：同步代码块优化
  /*  public static SingleTon getInstance(){
        if (singleTon==null){
            synchronized (SingleTon.class){
                if (singleTon==null){
                     singleTon=new SingleTon();
                }
            }
        }
        return singleTon;
    }*/

    public void print(){
        System.out.println("hello world");
    }
}
