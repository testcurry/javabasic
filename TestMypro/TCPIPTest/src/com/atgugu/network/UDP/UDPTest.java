package com.atgugu.network.UDP;/**
 * @Author Curry
 * @Create 2020-11-21:25
 */

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 *@Description todo
 *@ClassName UDPTest
 *@Author admin
 *@Date 2020/11/22 21:25
 *@Version 1.0
 */
public class UDPTest {
    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str="我是UDP方式发送的定时炸弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length,inet, 9090);
        socket.send(packet);
        socket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
