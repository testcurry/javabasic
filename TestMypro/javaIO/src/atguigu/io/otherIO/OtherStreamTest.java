package atguigu.io.otherIO;/**
 * @Author Curry
 * @Create 2020-11-16:48
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description todo
 * @ClassName OtherStreamTest
 * @Author admin
 * @Date 2020/11/22 16:48
 * @Version 1.0
 */
public class OtherStreamTest {
    public static void main(String[] args) {
//        test1();
    }

    //System.in  标准的输入流默认从键盘输入
    // System.out标准的输出流  默认输出到控制台
    //练习 从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后当输入e，或者exit的时候退出程序
    //使用System.in实现
    public static void test1() {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.print("请输入字符串：");
                String data = br.readLine();
                if (data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")) {
                    System.out.println("程序结束!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("print.txt");
            ps = new PrintStream(fos, true);
            if (ps != null) {
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
        }

    }

    //数据流DataInputStream  DataOutputStream
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("67jhgh");
        dos.flush();
        dos.writeInt(123);
        dos.flush();
        dos.writeBoolean(false);
        dos.flush();
    }

    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String s = dis.readUTF();
        int i = dis.readInt();
        boolean b = dis.readBoolean();
        System.out.print(s+i+b);
    }


}
