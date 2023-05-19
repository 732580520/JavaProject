package com.bjpowernode.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Demo07_BsServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器对象
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            // 获取客户端对象
            Socket socket = ss.accept();

            // 获取输入流
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            String path = line.split(" ")[1].substring(1);

            // 创建字节输入流对象
            FileInputStream fis = new FileInputStream(path);
            // 获取输出流
            OutputStream out = socket.getOutputStream();
            // 下列3句write()语句照抄即可
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("Content‐Type:text/html\r\n".getBytes());
            out.write("\r\n".getBytes());

            // 数据读写
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1 ) {
                out.write(bytes, 0, len);
            }
        }
    }
}
