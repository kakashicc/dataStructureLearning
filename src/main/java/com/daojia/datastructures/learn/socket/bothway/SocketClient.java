package com.daojia.datastructures.learn.socket.bothway;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/9 14:23.
 */
public class SocketClient {
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception{
        //要连接的服务端IP和端口
        String host = "127.0.0.1";
        int port = 55533;
        //与服务端建立连接
        Socket socket = new Socket(host,port);
        //获得输入流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好 这是客户端发送的信息";
        outputStream.write(message.getBytes("UTF-8"));
        //通过shutdownOutput告诉服务器已经发送完数据,后续只能接受数据
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println(" get message from server:"+sb);

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
