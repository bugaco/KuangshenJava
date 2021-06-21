package com.bugaco.lesson3UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        // 1.建立一个Socket
        DatagramSocket datagramSocket = new DatagramSocket();

        // 2.建个包
        String msg = "你好啊，服务器！";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;

        // 数据
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        // 3.发送包
        datagramSocket.send(packet);

        // 4.关闭流
        datagramSocket.close();
    }
}
