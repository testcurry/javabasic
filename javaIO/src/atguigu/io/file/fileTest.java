package atguigu.io.file;/**
 * @Author Curry
 * @Create 2020-11-22:39
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description todo
 * @ClassName file
 * @Author admin
 * @Date 2020/11/21 22:39
 * @Version 1.0
 */
public class fileTest {
    @Test
    public void test1() {
        File file = new File("hello.txt");
        System.out.println(file);
        File dir = new File("G:\\test\\io\\hello");
        System.out.println(dir);
        File fileChild = new File(dir, "hhhh.txt");
        System.out.println(fileChild.getAbsoluteFile());
        File file2 = new File("G://test//io//io1", "test.txt");
        System.out.println(file2);
    }

    @Test
    public void test2() {
        File file = new File("helloworld.txt");
        File file1 = new File("g://test//io//helloworld.txt");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));

        System.out.println(file1.length());
        System.out.println(file1.getParent());
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.lastModified());
    }

    @Test
    public void test3() throws IOException {
        File file = new File("D:\\IdeaProjects\\TestMypro");
        String[] list = file.list();
        for (String f : list) {
            System.out.println(f);
        }
        System.out.println();

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test4() throws IOException {
        File file1 = new File("G:\\test\\io\\io1\\hello.txt");
        File file = new File("G:\\test\\io\\123.txt");
        boolean newFile = file1.createNewFile();
        boolean b = file1.renameTo(file);

    }

    @Test
    public void test5() {
        File file = new File("hello.txt");
        file = new File("G://test//io");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println();
    }

    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        boolean newFile = file.createNewFile();
        if (!(file.exists())) {
            System.out.println("文件创建成功！");
        } else {
            file.delete();
            System.out.println("文件删除成功！");
        }

    }

    @Test
    public void test7() throws IOException {
        File dir = new File("G:\\test\\io\\io1//io2");
        boolean newDir = dir.mkdirs();
        if (newDir) {
            System.out.println("文件目录创建成功！");
        }
        File makeDir = new File("G:\\test\\io\\io1//io2//test.txt");

        boolean mkdir = makeDir.mkdirs();
        if (mkdir) {
            System.out.println("文件创建成功！");
        }
        File file = new File("G:\\test\\io\\io1//io2//test.txt");
        boolean delete = file.delete();
        System.out.println(delete);
        if (delete){
            System.out.println("删除成功！");
        }
    }
}