package atguigu.reflection;/**
 * @Author Curry
 * @Create 2020-11-23:54
 */

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *@Description todo
 *@ClassName ClassloaderTest
 *@Author admin
 *@Date 2020/11/22 23:54
 *@Version 1.0
 */
public class ClassloaderTest {
    @Test
    public void test1(){
        //对用自定义的类使用系统类加载器进行加载
        ClassLoader classLoader = ClassloaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent方法获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent（）无法获得引导类加载器
        //引导类加载器主要负责加载java核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }

    @Test
    //propertie用来读取配置文件
    public void test2() throws IOException {
        Properties pros = new Properties();
        //方式一
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);
        //方式二：使用系统类加载器
        InputStream is = ClassloaderTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        pros.load(is);
        Object user = pros.get("user");
        Object url = pros.get("url");
        System.out.println(user);
        System.out.println(url);


    }
}
