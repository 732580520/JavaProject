package com.bjpowernode.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
    java.net.Socket:该类实现客户端套接字（也称为“套接字”）。 套接字是两台机器之间通讯的端点。
    构造方法
        Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号。
        Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号。
    成员方法
        InputStream getInputStream() 返回此套接字的输入流。
        OutputStream getOutputStream() 返回此套接字的输出流。
 */
public class Demo02_Socket {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // 创建客户端对象
        Socket socket = new Socket("192.168.137.1",8080);
        while (true) {
            // 获取字节输出流
            OutputStream out = socket.getOutputStream();
            // 给服务器写请求数据
            System.out.print("客户端：");
            out.write(input.nextLine().getBytes());
            // 获取字节输入流
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);
            System.out.println(new String(bytes, 0, len));
        }

        // 关闭客户端
        // socket.close();
    }
}
