package com.bjpowernode.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
public class Demo04_UpSocket {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        Socket socket = new Socket("192.168.137.1",9999);
        // 创建字节输入流，读取需要上传的文件
        FileInputStream fis = new FileInputStream("images\\1.jpg");
        // 获取字节输出流，将文件写给服务端
        OutputStream out = socket.getOutputStream();
        // 数据读写
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        System.out.println("文件上传完成！！");
        // 关流
        socket.close();
        fis.close();

    }
}
