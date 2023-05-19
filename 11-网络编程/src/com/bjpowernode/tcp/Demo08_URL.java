package com.bjpowernode.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
    java.net.URL:URL代表统一资源定位符，指向互联网上"资源"的指针。资源可以是文件或目录，或者可以是对更复杂的对象的引用，例如对数据库或搜索引擎的查询。
	"http://www.example.com:8080/docs/resource1.html?user=zhangsan&passwrod=123"
	http:协议
	www.example.com：域名，也就是IP地址
	8080:端口号
	docs/resource1.html：请求的资源
	user=zhangsan&passwrod=123：参数信息
*/
public class Demo08_URL {
    public static void main(String[] args) throws IOException {
        String path = "https://www.zyjsq6.com/";
        // 创建URL对象
        URL url = new URL(path);
        // 打开连接
        URLConnection urlConnection = url.openConnection();
        System.out.println("urlConnection = " + urlConnection);

        // 获取输入流
        InputStream in = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }


    }
}
