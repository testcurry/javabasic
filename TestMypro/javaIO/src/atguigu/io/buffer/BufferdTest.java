package atguigu.io.buffer;/**
 * @Author Curry
 * @Create 2020-11-2:55
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description todo
 * @ClassName BufferdTest
 * @Author admin
 * @Date 2020/11/22 2:55
 * @Version 1.0
 */
public class BufferdTest {
    //实现非文本文件的复制
    @Test
    public void BufferdStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、造文件
            File srcPic = new File("Capture001.png");
            File destPic = new File("destPic.png");

            //2、造节点流
            FileInputStream fis = new FileInputStream(srcPic);
            FileOutputStream fos = new FileOutputStream(destPic);

            //3、造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的操作
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                //刷新缓冲区
//                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    //使用缓存流(字节流)实现文本文件的复制
    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testCopyFileWithBufferd() {
        Long start = System.currentTimeMillis();
        String srcFile = "C:\\Users\\admin\\Desktop\\test.mp4";
        String destFile = "C:\\Users\\admin\\Desktop\\testCP.mp4";
        copyFileWithBuffered(srcFile, destFile);

        Long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));
    }

    //使用bufferedWriter和bufferedReader实现对文本文件的复制
    @Test
    public void copyFileWithBufferedReaderBufferedWriter() {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("hello1.txt");
            File destFile = new File("helloBufferedReaderWriter.txt");

            FileReader fr = new FileReader(srcFile);
            FileWriter or = new FileWriter(destFile);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(or);

            //方式一使用char数组
//            int len;
//            char[] buffer = new char[1024];
//            while ((len=br.read(buffer))!=-1){
//                bw.write(buffer, 0, len);
//            }

            //方式二 使用String
            String data;
            while ((data = br.readLine()) != null) {
                //方式一：写出去一个换行
//                bw.write(data + "\n");
                //方式二:
                bw.write(data);
                bw.newLine();
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
            if (bw != null) {

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
