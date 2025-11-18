package atguigu.io.fileReadWriter;/**
 * @Author Curry
 * @Create 2020-11-1:51
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description todo
 * @ClassName FileReadWriter
 * @Author admin
 * @Date 2020/11/22 1:51
 * @Version 1.0
 */
public class TestFileReadWriter {
    @Test
    public void testFileRead() {
        FileReader fileReader = null;
        try {
            //实例化File类的对象，指明要操作的对象
            File file = new File("hello.txt");
            //2、指明具体的流
            fileReader = new FileReader(file);
//        3、读数据
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read的升级
    @Test
    public void test() {
        FileReader fr = null;
        try {
            //实例化File类的对象，指明要操作的对象
            File file = new File("hello.txt");
            //2、指明具体的流
            fr = new FileReader(file);
            //3、读数据
            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {
                //方式一
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuffer[i]);
//                }
                //或者 方式二
                String str = new String(cbuffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //将读取的内容存储到磁盘
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1、造文件
            File file = new File("hello1.txt");
            //2、造流
            fw = new FileWriter(file, true);//默认是false，也就是覆盖，为true则为添加
            //3、写出操作
            fw.write("\ntest我是中文aaaaa啊啊啊啊啊啊啊\n");
            fw.write("中国有嘻哈");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReadFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcfile = new File("hello1.txt");
            File destFile = new File("dest.txt");
            //文件损坏
//            File srcfile = new File("Capture001.png");
//            File destFile = new File("dest.png");
            fr = new FileReader(srcfile);
            fw = new FileWriter(destFile);
            int len;
            char[] cbuffer = new char[1024];
            while ((len = fr.read(cbuffer)) != -1) {
                fw.write(cbuffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {

                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}