package com.daojia.datastructures.learn.socket.bothway;

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
        //服务端监听端口
        int port = 55533;
        //新建服务端socket
        ServerSocket server = new ServerSocket(port);

        System.out.println("server端启动,等待连接的到来");
        Socket socket = server.accept();

        //获取输入流,并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意编码格式统一为UTF-8
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println(" get message form client :" + sb);

        //发送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(("Hello Client,I got the message:" + sb).getBytes("UTF-8"));

        //关闭连接
        outputStream.close();
        inputStream.close();
        socket.close();
        server.close();

        System.out.println("服务端方法结束");
    }
}
