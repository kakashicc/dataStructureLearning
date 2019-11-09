package com.daojia.datastructures.learn.socket.specificend;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: maosen
 * @Description: 服务端socket
 * @Date: Created in 2019/11/9 11:58.
 */
public class SocketServer {

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
        while (true) {
            // 首先读取两个字节表示的长度
            int first = inputStream.read();
            System.out.println("first:"+first);
            //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
            if(first==-1){
                break;
            }
            int second = inputStream.read();
            System.out.println("second:"+second);
            int length = (first << 8) + second;
            System.out.println("first << 8:"+(first << 8));
            System.out.println("length"+(length << 8));
            // 然后构造一个指定长的byte数组
            bytes = new byte[length];
            // 然后读取指定长度的消息即可
            inputStream.read(bytes);
            System.out.println("get message from client: " + new String(bytes, "UTF-8"));
        }
        inputStream.close();
        socket.close();
        server.close();
    }
}
