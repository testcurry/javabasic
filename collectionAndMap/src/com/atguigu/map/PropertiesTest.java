package com.atguigu.map;/**
 * @Author Curry
 * @Create 2020-11-3:24
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description todo
 * @ClassName PropertiesTest
 * @Author admin
 * @Date 2020/11/29 3:24
 * @Version 1.0
 */
public class PropertiesTest {

    @Test
    public void test() {
        FileInputStream fis = null;
        try {
            File file = new File("jdbc.properties");
            fis = new FileInputStream(file);
            Properties pros = new Properties();
            pros.load(fis);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            System.out.println(user+"==="+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
