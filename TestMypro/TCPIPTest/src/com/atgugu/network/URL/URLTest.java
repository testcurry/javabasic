package com.atgugu.network.URL;/**
 * @Author Curry
 * @Create 2020-11-23:04
 */

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description todo
 * @ClassName URLTest
 * @Author admin
 * @Date 2020/11/22 23:04
 * @Version 1.0
 */
public class URLTest {

    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());//url的文件名
        System.out.println(url.getQuery());
    }


}
