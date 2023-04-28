package com.bjpowernode.wait_notiry;
// 消费者线程任务
public class Get implements Runnable {
    // 创建容器对象
    private Resource resource;

    public Get(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resource.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
