package com.bugaco.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo01 {
    public static void main(String[] args) {

        InetAddress serverIP = null;
        Socket socket = null;
        OutputStream outputStream = null;

        try {
            // 地址
            serverIP = InetAddress.getByName("127.0.0.1");
            // 端口
            int port = 9999;
            // 创建socket连接
            socket = new Socket(serverIP, port);

            outputStream = socket.getOutputStream();
            outputStream.write("你好，BugaCo".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
