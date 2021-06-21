package com.bugaco.lesson3UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {

        // 开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        // 接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(packet); // 阻塞接收

        System.out.println(packet.getAddress().getHostAddress());
        String str = new String(packet.getData());
        System.out.println(str);
        // 关闭连接
        datagramSocket.close();
    }
}
