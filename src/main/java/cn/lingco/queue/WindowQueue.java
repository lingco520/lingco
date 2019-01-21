package cn.lingco.queue;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟卖票窗口
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-21 14:58
 * @since JDK 1.8
 */

public class WindowQueue {
    /**
     * 卖票的队列默认长度10
     */
    int maxSize = 10;
    CircleSequenceQueue queue = new CircleSequenceQueue(maxSize);
    /**
     * 用来统计卖票的数量，一天最多卖100张票
     */
    int num = 0;
    /**
     * 判断是否继续卖票
     */
    boolean isAlive = true;

    /**
     * 排队买票，使用同步机制
     * @throws Exception
     */
    public synchronized void producer() throws Exception {
        // count队列中的元素个数，如果该值小于maxSize则可以买票
        if (queue.count < maxSize) {
            // 等待买票的数量 + 1
            queue.append(num++);
            System.out.println("第" + num + "个客户排队等待买票");
            System.out.println("买票：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
            // 通知卖票线程可以卖票了
            this.notifyAll();
        } else {
            try {
                // 如果满了
                System.out.println("队列已满......请等待");
                // 队列满时，排队买票线程等待，其实等待卖票队伍里面离开一个人后来唤醒自己
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 排队卖票，使用同步机制
     * @throws Exception
     */
    public synchronized void consumer() throws Exception {
        // count队列中的元素个数，如果该值大于0，则说明有票可以继续卖票
        if (queue.count > 0) {
            Object obj = queue.delete();
            // 第几个人买到票了
            int temp = Integer.parseInt(obj.toString());
            System.out.println("第" + (temp + 1) + "个客户排队买到票离开队列");
            System.out.println("卖票：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
            // 如果当前队列为空，并且卖出票的数量大于等于100，说明卖票要结束
            if (queue.isEmpty() && this.num >= 100) {
                this.isAlive = false;
            }
            // 排队队伍离开一个人，可以进来一个人进行买票了,通知买票线程可以买了，唤醒买票线程
            this.notifyAll();
        } else {
            try {
                System.out.println("队列已空......请进入队伍准备买票");
                // 队列空时，排队卖票线程等待，其实等待买票队伍里面进来一个人后买票来唤醒自己
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
