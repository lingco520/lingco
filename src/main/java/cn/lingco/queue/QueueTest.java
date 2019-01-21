package cn.lingco.queue;

/**
 * 测试
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-21 15:41
 * @since JDK 1.8
 */

public class QueueTest {
    public static void main(String[] args) throws Exception{
        // 卖票与买票模拟，使用同一个窗口对象
        WindowQueue windowQueue = new WindowQueue();
        // 生产者
        Producer producer = new Producer(windowQueue);
        // 消费者
        Consumer consumer = new Consumer(windowQueue);

        // 排队卖票线程
        Thread pThread = new Thread(producer);
        // 排队买票线程
        Thread cThread = new Thread(consumer);

        // 开始排队卖票
        pThread.start();
        // 开始排队买票
        cThread.start();

    }
}
