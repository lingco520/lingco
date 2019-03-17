package cn.lingco.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 *
 * @author Administrator
 * @version 4.0
 * @date 2019-03-17 23:17
 * @since JDK 1.8
 */

public class Server {
    public static void main(String[] args) {
        try {
            // 创建一个服务器端的socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            // 调用accept()方法开始监听，等待客户端的连接
            System.out.println("服务器即将启动，等待客户端的连接");
            Socket socket = null;
            // 客户端连接数量
            int count = 0;
            // 循环监听客户端连接
            while (true) {
                socket = serverSocket.accept();
                // 创建一个新的线程，来实例化一个连接
                SocketServerThread serverThread = new SocketServerThread(socket);
                // 设置线程的优先级，范围为[1,10],默认为5
                serverThread.setPriority(4);
                // 启动线程
                serverThread.start();
                // 统计客户端数量
                count++;
                System.out.println("客户端连接数量：" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
