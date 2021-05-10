package com.bugaco.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo01 {
    public static void main(String[] args) {
        while (true) {
            ServerSocket serverSocket = null;
            Socket socket = null;
            InputStream inputStream = null;
            ByteArrayOutputStream byteArrayOutputStream = null;

            try {
                serverSocket = new ServerSocket(9999);
                socket = serverSocket.accept();

                inputStream = socket.getInputStream();

                // 管道流
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                System.out.println(byteArrayOutputStream.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭所有连接
                try {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    socket.close();
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

