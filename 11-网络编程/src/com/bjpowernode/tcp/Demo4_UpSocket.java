package com.bjpowernode.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Demo4_UpSocket {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket socket = new Socket("192.168.137.1",9999);
        //创建字节输入流，读取上传文件
        FileInputStream fis = new FileInputStream("C:\\Users\\73258\\Pictures\\微信图片_20230505211237.png");
        //获取字节输出流，将读取到的文件上传到服务器
        OutputStream out = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        System.out.println("文件上传成功");
        socket.close();
        fis.close();
    }
}
