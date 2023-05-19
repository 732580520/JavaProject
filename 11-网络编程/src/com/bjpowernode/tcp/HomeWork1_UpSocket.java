package com.bjpowernode.tcp;

import java.io.*;
import java.net.Socket;

public class HomeWork1_UpSocket {
    public static void main(String[] args) throws IOException {
        Socket socket= new Socket("192.168.137.109",9999);
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\02-java进阶\\13-网络编程-JSON\\作业\\我是GBK格式.txt"),"GBK"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
        }
        System.out.println("文件上传成功");
        br.close();
        bw.close();
        socket.close();
    }
}
