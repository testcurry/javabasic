package com.atgugu.network.TCP;/**
 * @Author Curry
 * @Create 2020-11-18:45
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description todo
 * @ClassName TCPTest
 * @Author admin
 * @Date 2020/11/22 18:45
 * @Version 1.0
 */
public class TCPTest {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("192.168.17.1");
            socket = new Socket(inet, 22222);
            os = socket.getOutputStream();
            os.write("我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server() {
        Socket socket = null;
        InputStream is = null;
        ServerSocket ss = null;
        ByteArrayOutputStream bos = null;
        try {
            ss = new ServerSocket(22222);
            socket = ss.accept();
            is = socket.getInputStream();
            bos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println("收到了来自：" + socket.getInetAddress().getHostAddress() + "的消息..");
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
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
