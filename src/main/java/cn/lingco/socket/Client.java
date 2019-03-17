package cn.lingco.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端
 * @author Administrator
 * @version 4.0
 * @date 2019-03-17 23:27
 * @since JDK 1.8
 */

public class Client {
    public static void main(String[] args) {
        try {
            // 创建客户端socket，制定服务器地址和端口
            Socket socket = new Socket("localhost", 8888);
            // 获取输出流，向服务器端发送信息
            // 字节输出流
            OutputStream os = socket.getOutputStream();
            // 将输出流转换成打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write("我是客户端，数据为->用户名：admin；密码：123456");
            pw.flush();
            // 关闭输出流
            socket.shutdownOutput();
            // 获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("服务端返回数据为：" + info);
            }
            // 关闭资源
            br.close();
            is.close();
            os.close();
            // 不需要关闭输出流pw，提前关闭输出流，有可能导致socket也会关闭，
            // 在关闭socket时，输出流也会一并关闭
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
