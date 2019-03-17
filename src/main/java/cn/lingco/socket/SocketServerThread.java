package cn.lingco.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Administrator
 * @version 4.0
 * @date 2019-03-17 23:01
 * @since JDK 1.8
 */

public class SocketServerThread extends Thread {
    // 和本线程相关的socket
    Socket socket = null;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    // 线程执行的操作，响应客户端的请求
    public void run() {
        // 获取输入流，并读取客户端信息
        // 字节输入流
        InputStream is = null;
        OutputStream os = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        try {
            is = socket.getInputStream();
            // 将字节流转换成字符流
            isr = new InputStreamReader(is);
            // 为输入流添加缓冲
            br = new BufferedReader(isr);
            String info = null;
            // 循环读取客户端信息
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端发来信息：" + info);
            }
            // 关闭输入流
            socket.shutdownInput();
            // 获取输出流，响应客户端信息
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("我是服务端，已收到你发来的信息,欢迎你！");
            // 调用flush()方法，将缓冲输出
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
