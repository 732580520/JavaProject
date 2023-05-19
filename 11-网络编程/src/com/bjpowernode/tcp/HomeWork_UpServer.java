package com.bjpowernode.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWork_UpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        while (true){
            Socket socket = ss.accept();
             new Thread(()->{
                 try {
                     BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     String fileName=socket.getInetAddress().getHostAddress();
                     File file = new File( fileName + ".txt");
                     int name=1;
                     while (file.exists()){
                         file = new File(fileName + "(" + name + ").txt");
                         name++;
                     }
                     BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                     String line;
                     while ((line=br.readLine())!=null){
                         bw.write(line);
                         bw.newLine();
                     }
                     System.out.println("文件下载完成！！");
                     socket.close();
                     bw.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }).start();
        }
    }
}
