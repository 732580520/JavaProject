package com.bjpowernode.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    java.net.InetAddress:此类表示Internet协议（IP）地址。
    成员方法
        static InetAddress getByName​(String host) 确定主机名称的IP地址。
            String host：IP   主机名   域名
        static InetAddress[] getAllByName​(String host) 给定主机的名称，根据系统上配置的名称服务返回其IP地址数组。
 */
public class Demo01_InetAddress {
    public static void main(String[] args) throws Exception {
        // 创建IP对象
        InetAddress byName = InetAddress.getByName("192.168.137.100");
        //InetAddress byName = InetAddress.getByName("www.baidu.com");
        //InetAddress byName = InetAddress.getByName("powernode");
        System.out.println("byName = " + byName);
        // 获取当前对象的IP字符串
        String ip = byName.getHostAddress();
        System.out.println("ip = " + ip);
        String hostName = byName.getHostName();
        System.out.println("hostName = " + hostName);

        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println("inetAddress = " + inetAddress);
        }
    }
}
