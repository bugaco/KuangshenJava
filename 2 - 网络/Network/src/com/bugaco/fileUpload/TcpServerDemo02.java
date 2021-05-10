package com.bugaco.fileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1 创建服务
        ServerSocket serverSocket = new ServerSocket(9999);

        // 2 监听客户端的连接
        Socket socket = serverSocket.accept();

        // 3 获取输入流
        InputStream inputStream = socket.getInputStream();

        // 4 文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("receive.png"));

        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != 01) {
            fileOutputStream.write(buffer, 0, len);
        }

        // 通知客户端接收完毕了
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我接收完毕了，你可以断开了。".getBytes());
        // 5 关闭资源
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

}
