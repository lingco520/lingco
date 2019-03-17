package cn.lingco.elasticsearch;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetAddress;

/**
 * java连接elasticsearch
 *
 * @author Administrator
 * @version 4.0
 * @date 2019-02-25 21:42
 * @since JDK 1.8
 */

public class TestElasticsearchConnection {
    public final static String HOST = "127.0.0.1";

    public final static int PORT = 9300;//http请求的端口是9200，客户端是9300

    public static void main(String[] args) throws Exception{
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST),PORT));
//        System.out.println(client);
//        client.close();
    }
}
