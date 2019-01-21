package cn.lingco.queue;

/**
 * 自定义队列接口
 * @author TangGuangMing
 * @version 4.0
 * @date 2019-01-21 14:15
 * @since JDK 1.8
 */
public interface UserQueue {
    /**
     * 入队
     * @param obj
     * @throws Exception
     */
    void append(Object obj) throws Exception;

    /**
     * 出队
     * @return
     * @throws Exception
     */
    Object delete() throws Exception;

    /**
     * 获得对头元素
     * @return
     * @throws Exception
     */
    Object getFront() throws Exception;

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();
}
