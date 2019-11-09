package com.daojia.datastructures.learn.socket.basic;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/9 14:23.
 */
public class SocketClient {
    public static void main(String[] args) throws Exception{
        //要连接的服务端IP和端口
        String host = "127.0.0.1";
        int port = 55533;
        //与服务端建立连接
        Socket socket = new Socket(host,port);
        System.out.println("客户端已与服务端建立连接");
        //获得输入流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好 这是客户端发送的信息";
        outputStream.write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
        System.out.println("客户端连接结束");
    }
}
