package com.bjpowernode.lambda;

import java.io.File;
import java.io.FileFilter;

public class Demo03_FileFilter {
    public static void main(String[] args) {
        // 创建文件对象
        File file = new File("d:\\demo");
        // 只要.txt文件
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt") && pathname.isFile();
            }
        });
        // Lambda表达式
        //File[] files1 = file.listFiles((File pathname)->{return pathname.isFile() && pathname.getName().endsWith(".txt");});
        File[] files1 = file.listFiles( pathname -> pathname.isFile() && pathname.getName().endsWith(".txt") );

        // 遍历数组
        for (File dir : files1) {
            System.out.println(dir);
        }
    }
}
