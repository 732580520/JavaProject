package com.bjpowernode.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
    java.net.ServerSocket:这个类实现了服务器套接字。
	    服务器套接字等待通过网络进入的请求。它根据该请求执行一些操作，然后可能将结果返回给请求者。
    构造方法
        ServerSocket​(int port) 创建绑定到指定端口的服务器套接字。
    成员方法
        Socket accept​() 侦听要连接到此套接字并接受它。'获取客户端对象。
 */
public class Demo03_ServerSocket {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // 创建服务端对象
        ServerSocket ss = new ServerSocket(8080);
        // 获取客户端对象
        Socket socket = ss.accept();
        while (true) {
            /* System.out.println("socket = " + socket);
            InetAddress inetAddress = socket.getInetAddress();
            String ip = inetAddress.getHostAddress();
            System.out.println("ip = " + ip);
            String hostName = inetAddress.getHostName();
            System.out.println("hostName = " + hostName);*/
            // 获取字节输入流
            InputStream in = socket.getInputStream();
            // 读取请求数据
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);
            System.out.println(new String(bytes, 0, len));

            // 获取字节输出流
            OutputStream out = socket.getOutputStream();
            System.out.print("服务端：");
            out.write(input.nextLine().getBytes());
        }
        // 关闭客户端
        //socket.close();
    }
}
