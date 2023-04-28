package com.bjpowernode.wait_notiry;
// 生产者线程任务
public class Set implements Runnable {
    // 创建容器对象
    private Resource resource;

    public Set(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resource.set("杜蕾斯");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
