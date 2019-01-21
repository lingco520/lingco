package cn.lingco.queue;

/**
 * 模拟 买票 消费者
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-21 15:29
 * @since JDK 1.8
 */

public class Producer implements Runnable{
    /**
     * 买票窗口
     */
    WindowQueue windowQueue;

    /**
     * 保证和消费者使用同一个对象
     */
    public Producer(WindowQueue windowQueue) {
        this.windowQueue = windowQueue;
    }
    @Override
    public void run() {
        while (windowQueue.num < 100) {
            try {
                // 消费者，执行买票
                windowQueue.producer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
