package com.atgugu.network.URL;/**
 * @Author Curry
 * @Create 2020-11-23:13
 */

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *@Description todo
 *@ClassName URLTest1
 *@Author admin
 *@Date 2020/11/22 23:13
 *@Version 1.0
 */
public class URLTest1 {
    //前提是启动tomcat
    @Test
    public void test1()  {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("Curryurl.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer, 0, len);

            }
            System.out.println("下载完成..");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection!=null){

                urlConnection.disconnect();
            }
        }

    }
}
