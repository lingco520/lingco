package cn.lingco.queue;

/**
 * 模拟 卖票 生产者
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-21 15:38
 * @since JDK 1.8
 */

public class Consumer implements Runnable{
    WindowQueue windowQueue;

    /**
     * 保证卖票与买票同步
     * @param windowQueue
     */
    public Consumer(WindowQueue windowQueue) {
        this.windowQueue = windowQueue;
    }
    @Override
    public void run() {
        // 判断是否可以继续卖票
        while (windowQueue.isAlive) {
            try {
                // 卖票
                windowQueue.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
