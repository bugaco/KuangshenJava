package com.bugaco.fileUpload;

import java.io.*;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) throws Exception {

        // 1 创建一个socket连接
        Socket socket = new Socket("127.0.0.1", 9999);

        // 2 创建一个输出流
        OutputStream outputStream = socket.getOutputStream();

        // 3 读取文件
        FileInputStream fileInputStream = new FileInputStream(new File("1.png"));

        // 4 写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        // 通知服务器，我已经传完了
        socket.shutdownOutput();

        // 确定服务器接收完毕后，再断开连接
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bufferString = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(bufferString)) != -1) {
            byteArrayOutputStream.write(bufferString, 0, len2);
        }
        System.out.println(byteArrayOutputStream.toString());

        // 5 关闭资源
        byteArrayOutputStream.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}
