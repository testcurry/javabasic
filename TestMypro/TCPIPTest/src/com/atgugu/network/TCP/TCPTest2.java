package com.atgugu.network.TCP;/**
 * @Author Curry
 * @Create 2020-11-19:52
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@Description todo
 *@ClassName TCPTest2
 *@Author admin
 *@Date 2020/11/22 19:52
 *@Version 1.0
 */
public class TCPTest2 {

    //客户端
    @Test
    public void client() throws IOException {
        InetAddress inet=InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet, 8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("curry.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer);
        }
        System.out.println("传输完成。。");
        fis.close();
        os.close();
        socket.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("curry1.jpg");
        byte[] buffer = new byte[2];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("接收完成...");


    }
}
