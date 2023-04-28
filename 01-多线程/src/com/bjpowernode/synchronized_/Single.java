package com.bjpowernode.synchronized_;

/*public class Single {
    // 私有构造方法
    private Single(){}
    // 创建本类的对象
    private static Single s = new Single();
    // 返回本类对象的方法
    public static Single getInstance() {
        return s;
    }
}*/
public class Single {
    // 锁
    private static Object lock = new Object();
    // 私有构造方法
    private Single(){}
    // 创建本类的对象
    private static Single s;
    // 返回本类对象的方法
    public static /*synchronized*/ Single getInstance() {
        // 为了提高效率，当单例的对象被创建完成之后，其它的线程不会在进入同步代码块。
        if(s == null) {
            synchronized (lock) {
                // 判断是否为空
                if (s == null) {
                    s = new Single();
                }
            }
        }
        return s;
    }
}
