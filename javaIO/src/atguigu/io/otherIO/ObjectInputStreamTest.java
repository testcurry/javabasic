package atguigu.io.otherIO;/**
 * @Author Curry
 * @Create 2020-11-17:56
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description todo
 * @ClassName ObjectInputStreamTest
 * @Author admin
 * @Date 2020/11/22 17:56
 * @Version 1.0
 */
public class ObjectInputStreamTest {
    //序列化过程：将内存中的java对象保存到磁盘中或通过网络传输过去
    @Test
    public void test() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.data"));
            oos.writeObject(new Person("test", 18));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //反序列化过程，将磁盘中的一个对象还原为内存中的一个java对象 使用ObjectInputStream实现
    @Test
    public void testObjectInputStream()  {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.data"));
            Object obj = ois.readObject();
            Person person = (Person) obj;
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
