package com.bjpowernode.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo05_UpServer {
    public static void main(String[] args) throws IOException {
        // 创建服务端对象
        ServerSocket ss = new ServerSocket(9999);
        while (true) {
            // 获取客户端对象
            Socket socket = ss.accept();
            // 开启线程
            new Thread(()->{
                // 线程任务
                try {
                    // 获取字节输入流，读取上传的文件
                    InputStream in = socket.getInputStream();
                    // 创建字节输出流，写入上传的文件
                    // 时间戳
                    //long fileName = System.currentTimeMillis() + new Random().nextInt();
                    //String fileName = UUID.randomUUID().toString();
                    String fileName = socket.getInetAddress().getHostAddress();
                    // 创建File对象
                    File file = new File("images\\" + fileName + ".jpg");
                    int name = 1;
                    // 判断文件是否存在
                    while (file.exists()) {
                        file = new File("images\\" + fileName + "(" + name + ").jpg");
                        name++;
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    // 数据读写
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = in.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    System.out.println("文件下载完成！！");
                    // 关流
                    socket.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
