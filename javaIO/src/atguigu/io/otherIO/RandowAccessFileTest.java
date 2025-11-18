package atguigu.io.otherIO;/**
 * @Author Curry
 * @Create 2020-11-18:11
 */


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description todo
 * @ClassName RandowAccessFileTest
 * @Author admin
 * @Date 2020/11/22 18:11
 * @Version 1.0
 */
public class RandowAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("Curry.jpg"), "r");
            raf2 = new RandomAccessFile("Curry1.jpg", "rw");
            int len;
            byte[] buffer = new byte[1024];
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2()  {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");
            raf.seek(3);
            StringBuilder builder = new StringBuilder((int) (new File("hello.txt").length()));

            byte[] buffer = new byte[1024];
            int len;
            while ((len=raf.read(buffer))!=-1){
                builder.append(new String(buffer, 0, len));
            }
            raf.seek(3);
            raf.write("xyz".getBytes());
            raf.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
