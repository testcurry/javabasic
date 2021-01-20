package com.atgugu.network.TCP;/**
 * @Author Curry
 * @Create 2020-11-20:16
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@Description todo
 *@ClassName TCPTest3
 *@Author admin
 *@Date 2020/11/22 20:16
 *@Version 1.0
 */
public class TCPTest3 {
    //客户端
    @Test
    public void client() throws IOException {
        InetAddress inet= InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet, 8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("curry1.jpg");
        int len;
        byte[] buffer = new byte[1024];
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();
        //接受服务端的消息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[5];
        int len1;
        while ((len1=is.read(buffer1))!=-1){
            bos.write(buffer,0,len1);
        }
        System.out.println(bos.toString());
        bos.close();
        fis.close();
        socket.close();
        os.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("curry3.jpg");
        byte[] buffer = new byte[5];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0, len);
        }
        System.out.println("已接收客户端的文件！");

        OutputStream os = socket.getOutputStream();
        os.write("照片已收到，谢谢".getBytes());
        is.close();
        fos.close();
        ss.close();
    }
}
