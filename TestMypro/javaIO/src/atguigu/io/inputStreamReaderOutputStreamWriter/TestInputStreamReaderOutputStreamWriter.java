package atguigu.io.inputStreamReaderOutputStreamWriter;/**
 * @Author Curry
 * @Create 2020-11-14:14
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description todo
 * @ClassName TestInputStreamReaderOutputStreamWriter
 * @Author admin
 * @Date 2020/11/22 14:14
 * @Version 1.0
 */
public class TestInputStreamReaderOutputStreamWriter {

    //转换流
    //InputStreamReader 将字节输入流转换为字符输入流
    // OutputStreamWriter 将字符输出流转换为字节输出流

    @Test
    public void testInputStreamReader() throws IOException {
        File file = new File("hello1.txt");

        FileInputStream fis = new FileInputStream(file);
        //使用使用转换流转换
        InputStreamReader isr = new InputStreamReader(fis);

        char[] buffer = new char[5];
        int len;
        while ((len = isr.read(buffer)) != -1) {
            System.out.print(new String(buffer));
        }

        isr.close();
    }
    //综合使inputStreamRead和outputStreamWriter
    @Test
    public void test() throws Exception {
        File file = new File("hello1.txt");
        File destfile = new File("destConvert.txt");
//        File destfile1 = new File("destConvert1.txt");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(destfile);
//        FileReader fr = new FileReader(file);
//        FileWriter fw = new FileWriter(destfile1);

        InputStreamReader isr = new InputStreamReader(fis, "utf-8");//将fis转换为字符的输入流
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");//将字符的输出流转换为字节的输出流

        int len;
        byte[] buffer1 = new byte[5];
        char[] buffer = new char[5];
        while ((len = isr.read(buffer)) != -1) {
            osw.write(buffer, 0, len);
//            System.out.print(new String(buffer));
        }
//        while ((len = isr.read(buffer1)) != -1) {
//            fw.write(buffer1, 0, len);
////            System.out.print(new String(buffer));
//        }
        isr.close();
        osw.close();

    }
}
