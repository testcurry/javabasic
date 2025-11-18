package atguigu.io.inputOutputStream;/**
 * @Author Curry
 * @Create 2020-11-0:30
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description todo
 * @ClassName FileInputOutStream
 * @Author admin
 * @Date 2020/11/22 0:30
 * @Version 1.0
 */
public class FileInputOutputStream {
    /*
     *@Description 使用FileInputStream字节流处理文件可能出现乱码
     *@Author Testcy
     * @param
     *@Date 0:54 2020/11/22
     *@return void
     */
    @Test
    public void test() {
        //造文件
        FileInputStream is = null;
        try {
            File file = new File("hello.txt");
            //造流
            is = new FileInputStream(file);
            //读数据
            int len;
            byte[] buffer = new byte[5];
            while ((len = is.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        //1、造文件
        FileInputStream is = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("Capture001.png");
            //造流
            is = new FileInputStream(srcFile);
            fos = new FileOutputStream("destFile.jpg");
            //读数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路徑的文件复制方法
    public void copyFile(String srcPath, String destPath) {
        //1、造文件
        FileInputStream is = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2、造流
            is = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //3、读数据
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile1() {
        long start = System.currentTimeMillis();
        String srcFile="C:\\Users\\admin\\Desktop\\test.mp4";
        String destFile="C:\\Users\\admin\\Desktop\\test.avi";
        copyFile(srcFile, destFile);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end - start));//40638
    }
}