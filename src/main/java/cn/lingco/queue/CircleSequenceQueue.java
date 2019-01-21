package cn.lingco.queue;

/**
 * 循环顺序队列
 *
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-21 14:19
 * @since JDK 1.8
 */

public class CircleSequenceQueue implements UserQueue {
    // 默认队列的长度
    static final int defaultsize = 10;
    /**
     * 对头
     */
    int front;
    /**
     * 队尾
     */
    int rear;
    /**
     * 统计元素个数的计数器
     */
    int count;
    /**
     * 队的最大长度
     */
    int maxSize;
    /**
     * 队列，使用数组实现
     */
    Object[] queue;

    /**
     * 默认构造
     */
    public CircleSequenceQueue() {
        init(defaultsize);
    }

    /**
     * 通过给定长度构造
     * @param size
     */
    public CircleSequenceQueue(int size) {
        init(size);
    }
    public void init(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Object[size];
    }

    @Override
    public void append(Object obj) throws Exception {
        if (count > 0 && front == rear) {
            throw new Exception("队列已满");
        }
        // 队尾插入数据
        queue[rear] = obj;
        // 通过这种方法让对标索引值不停的重复
        rear = (rear + 1) % maxSize;
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        // 去除对头的元素，同时修改对头的索引值
        Object obj = queue[front];
        // 对头索引值，一样通过+1驱魔运算来实现循环索引效果
        front = (front + 1) % maxSize;
        count--;
        return obj;
    }

    @Override
    public Object getFront() throws Exception {
        if (!isEmpty()) {
            return queue[front];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
